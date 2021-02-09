package geometric;

public class Rectangle implements Geometric {
    private double x, y, width, height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double leftBorder() {
        return x;
    }

    public double rightBorder() {
        return x + width;
    }

    public double topBorder() {
        return y + height;
    }

    public double bottomBorder() {
        return y;
    }

    public double area() {
        return height * width;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return "This Rectangle is at postion x: " + Double.toString(x) + ", y: " + Double.toString(y)
                + " It has a width of " + Double.toString(width) + " and a height of " + Double.toString(height)
                + " It has an area of " + Double.toString(area());
    }

    @Override
    public int compareTo(Geometric s) {
        return 0;
    }

}
