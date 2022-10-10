public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y){
        setX(x);
        setY(y);
    }
    public int getX(){ return x;}
    public int getY() {return y;}
    public void setX(int x)
    {
        if (x > Globals.ALL_DOTS-1)
        {
            this.x = 0;
            return;
        }
        if (x < 0)
        {
            this.x = Globals.ALL_DOTS-1;
            return;
        }
        this.x = x;
    }
    public void setY(int y)
    {
        if (y > Globals.ALL_DOTS)
        {
            this.y = 0;
            return;
        }
        if (y < 0)
        {
            this.y = Globals.ALL_DOTS;
            return;
        }
        this.y = y;
    }
    public static boolean isEqual(Coordinate first, Coordinate second){ return first.x == second.x && first.y == second.y;}
    public void assignCoordinate(Coordinate coordinate){
        this.x = coordinate.getX();
        this.y = coordinate.getY();
    }
    public void incrementX() {setX(++x);}
    public void incrementY() {setY(++y);}
    public void decrementX() {setX(--x);;}
    public void decrementY() {setY(--y);}

}
