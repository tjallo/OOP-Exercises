package geometric;

public interface Geometric extends Comparable<Geometric>{

    public double leftBorder();

    public double rightBorder();

    public double topBorder();

    public double bottomBorder();

    public double area();

    public void move(double dx, double dy);

    public String toString();

    // public int compareTo();
}
