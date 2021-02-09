package geometric;

public interface Geometric {

    public double leftBorder();

    public double rightBorder();

    public double topBorder();

    public double bottomBorder();

    public double area();

    public void move(double dx, double dy);

    public String toString();

    public double getXval();

    public double getYval();

}
