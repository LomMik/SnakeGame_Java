import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame
{
    public MainWindow()
    {
        setTitle("Snake_Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Globals.WINDOW_SIZE_WIDTH+16,Globals.WINDOW_SIZE_HEIGHT+15);
        setLocation(Globals.SET_LOCATION_WIDTH, Globals.SET_LOCATION_HEIGHT);
        setBackground(Color.BLACK);
        add(new GameField());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        MainWindow mainWindow = new MainWindow();
    }
}
