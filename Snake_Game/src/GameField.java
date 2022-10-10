import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameField extends JPanel implements ActionListener
{
    Snake snake;
    Apple apple;
    private Timer timer;
    public GameField()
    {
        snake = new Snake(14,Direction.down);
        apple = new Apple(0,4,Color.cyan);
        initGame();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                snake.changeDirection(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setFocusable(true);
        setSize(Globals.WINDOW_SIZE_WIDTH,Globals.WINDOW_SIZE_HEIGHT);
    }
    private void initGame()
    {
        timer = new Timer(250,this);
        timer.start();
    }
    @Override
    public void paint(Graphics g)
    {
        super.paintComponents(g);
        if (Globals.IN_GAME)
        {
            paintField(g);
            g.setColor(apple.getColor());
            g.fillRect(apple.coordinate.getX()*Globals.DOT_SIZE + Globals.DOT_SIZE/4,apple.coordinate.getY()*Globals.DOT_SIZE + Globals.DOT_SIZE/4,Globals.DOT_SIZE/2,Globals.DOT_SIZE/2 );
            for (int i = 0; i < snake.getLength();i++)
            {
                g.setColor(snake.getColor(i));
                g.fillRect(snake.getX(i) * Globals.DOT_SIZE, snake.getY(i) * Globals.DOT_SIZE, Globals.DOT_SIZE, Globals.DOT_SIZE);
            }
        }
        else {

            g.setColor(Color.white);
            g.drawString("GAME OVER",Globals.WINDOW_SIZE_WIDTH/2-40,Globals.WINDOW_SIZE_HEIGHT/2-40);
        }
    }
    private void paintField(Graphics g)
    {
        boolean color = true;
        for (int i = 0; i < Globals.ALL_DOTS+1; i++)
        {
            for (int j = 0; j < Globals.ALL_DOTS; j++)
            {
                if (color)
                {
                    g.setColor(Color.black);
                    color=false;
                }
                else
                {
                    g.setColor(Color.DARK_GRAY);
                    color = true;
                }
                g.fillRect(j*Globals.DOT_SIZE, i*Globals.DOT_SIZE, Globals.DOT_SIZE, Globals.DOT_SIZE);
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (Globals.IN_GAME)
        {
            snake.move();
            snake.checkCollision();
            Globals.KEY_PRESSED = false;
            if (Coordinate.isEqual((snake.getHeadCoordinate()), apple.coordinate))
            {
                snake.eatApple();
                apple.createApple();
            }
        }
        repaint();
    }
}
