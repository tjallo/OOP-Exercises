package geometric;


public class Circle implements Geometric, Comparable<Geometric> {
    private double x, y, r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double leftBorder() {
        return x - r;
    }

    public double rightBorder() {
        return x + r;
    }

    public double topBorder() {
        return y + r;
    }

    public double bottomBorder() {
        return y - r;
    }

    public double area() {
        // Area of a circle is πr^2
        return Math.PI * (r * r);
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return "Type: Circle, xPos: " + Double.toString(x) + ", yPos: " + Double.toString(y) + ", Radius: "
                + Double.toString(r) + ", Area: " + Double.toString(area());
    }

    public double getXval() {
        return x;
    }

    public double getYval() {
        return y;
    }

    @Override
    public int compareTo(Geometric g) {

        double o1 = area();
        double o2 = g.area();

        if (o1 < o2) {
            return -1;
        } else if (o2 > o1) {
            return 1;
        }
        return 0;

    }

    

}
