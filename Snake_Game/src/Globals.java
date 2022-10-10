import java.awt.*;

public class Globals
{
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static final double SCREEN_SIZE_WIDTH = screenSize.getWidth();
    static final double SCREEN_SIZE_HEIGHT = screenSize.getHeight();
    static final int WINDOW_SIZE_WIDTH = 400;
    static final int WINDOW_SIZE_HEIGHT = 440;
    static final int WINDOW_BORDER = 40;
    static final int SET_LOCATION_WIDTH = (int) Globals.SCREEN_SIZE_WIDTH/2-Globals.WINDOW_SIZE_WIDTH/2;
    static final int SET_LOCATION_HEIGHT = (int)Globals.SCREEN_SIZE_HEIGHT/2-Globals.WINDOW_SIZE_HEIGHT/2;
    static final int DOT_SIZE = 16;
    static final int ALL_DOTS = WINDOW_SIZE_WIDTH/DOT_SIZE;
    static boolean IN_GAME = true;
    static boolean KEY_PRESSED = false;

}
