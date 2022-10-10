import java.awt.*;
import java.util.Random;

public class Apple {
    Coordinate coordinate;
    private Color color;

    public Apple(int x, int y, Color color)
    {
        coordinate = new Coordinate(x,y);
        this.color = color;
    }
    public Color getColor() {return color;}
    public Apple()
    {
        coordinate = new Coordinate((int)(Math.random()*((double)Globals.ALL_DOTS - (double)1)),(int)(Math.random()*(Globals.ALL_DOTS - 1)));
        this.color = Snake.colors.get((int)Math.random() % 500);
    }

    public void createApple()
    {
        coordinate = new Coordinate((int)(Math.random()*((double)Globals.ALL_DOTS - (double)1)),(int)(Math.random()*(Globals.ALL_DOTS - 1)));
        this.color = Snake.colors.get((int)Math.random() % 500);
    }
}
