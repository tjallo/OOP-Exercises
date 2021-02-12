package geometric;

public class Rectangle implements Geometric, Comparable<Geometric> {
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
        return "Type: Rectangle, xPos: " + Double.toString(leftBorder()) + ", yPos: " + Double.toString(bottomBorder()) + ", Width: "
                + Double.toString(width) + ", Heigth: " + Double.toString(height) + ", Area: "
                + Double.toString(area());
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
