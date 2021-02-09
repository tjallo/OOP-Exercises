package geometric;

public class Circle implements Geometric {
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

    
}
