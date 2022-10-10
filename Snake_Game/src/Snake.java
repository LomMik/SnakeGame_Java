import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake
{
    private List<Fragment> listFragment;
    static List<Color> colors;
    private Direction direction;
    private int length;

    public Snake(int length,Direction direction )
    {
        listFragment = new ArrayList<>();
        colors = new ArrayList<>();
        initColors(colors);
        listFragment.add(new Fragment(0,0,colors.get(0)));
        this.length = length;
        this.direction = direction;
        for (int i = 0; i < length-1; i++)
        {
            listFragment.add(new Fragment(listFragment.get(i).coordinate.getX() + 1, listFragment.get(i).coordinate.getY(), colors.get(i)));
        }
    }
    private void initColors(List<Color> colors)
    {
        for (int r=0; r<20; r++) colors.add(new Color(r*255/20,       255,         0));
        for (int g=20; g>0; g--) colors.add(new Color(      255, g*255/20,         0));
        for (int b=0; b<20; b++) colors.add(new Color(      255,         0, b*255/20));
        for (int r=20; r>0; r--) colors.add(new Color(r*255/20,         0,       255));
        for (int g=0; g<20; g++) colors.add(new Color(        0, g*255/20,       255));
        for (int b=20; b>0; b--) colors.add(new Color(        0,       255, b*255/20));
        colors.add(new Color(        0,       255,         0));
    }
    public void eatApple()
    {
        listFragment.add(new Fragment(
                listFragment.get(listFragment.size()-1).coordinate.getX(),
                listFragment.get(listFragment.size()-1).coordinate.getY(),
                colors.get(listFragment.size()-1)
        ));
        length++;
    }
    public Color getColor (int index) {return listFragment.get(index).color;}
    public int getX (int index) {return listFragment.get(index).coordinate.getX();}
    public int getY (int index) {return listFragment.get(index).coordinate.getY();}
    public Coordinate getHeadCoordinate() {return listFragment.get(0).coordinate;}
    public int getLength() {return length;}
    public void move()
    {
        for (int i = listFragment.size()-1; i > 0; i--)
        {
            listFragment.get(i).coordinate.assignCoordinate(listFragment.get(i-1).coordinate);
        }
        if (direction == Direction.right)
            listFragment.get(0).coordinate.incrementX();
        if (direction == Direction.down)
            listFragment.get(0).coordinate.incrementY();
        if (direction == Direction.left)
            listFragment.get(0).coordinate.decrementX();
        if (direction == Direction.up)
            listFragment.get(0).coordinate.decrementY();
    }
    public void changeDirection (char keyChar)
    {
        if (Globals.KEY_PRESSED == true)
            return;
        else
            Globals.KEY_PRESSED = true;
        if (keyChar == 'a' && direction != Direction.right)
        {
            direction = Direction.left;
            return;
        }
        if (keyChar == 'd' && direction != Direction.left)
        {
            direction = Direction.right;
            return;
        }
        if (keyChar == 'w' && direction != Direction.down)
        {
            direction = Direction.up;
            return;
        }
        if (keyChar == 's' && direction != Direction.up)
        {
            direction = Direction.down;
            return;
        }
    }
    public void checkCollision()
    {
        for (int i = 1;i < length;i++)
        {
            if (Coordinate.isEqual(listFragment.get(0).coordinate,listFragment.get(i).coordinate))
                Globals.IN_GAME =false;
        }
    }
    class Fragment
    {
        private Coordinate coordinate;
        private final Color color;
        public Fragment(int x, int y, Color color)
        {
            coordinate = new Coordinate(x,y);
            this.color = color;
        }
    }

}
