package geometric;

import java.util.Arrays;

public class Assignment03Tester {
	private Circle c;
	private Rectangle r;
	private Geometric[] shapes;

	public Assignment03Tester() {

	}

	public void createCircle(double x, double y, double r) {
		c = new Circle(x, y, r);
		addToArray(c);
	}

	public void createRectangle(double x, double y, double width, double height) {
		r = new Rectangle(x, y, width, height);
		addToArray(r);
	}

	public double topBorder(int index) {
		Geometric s = shapes[index];
		return s.topBorder();
	}

	public double rightBorder(int index) {
		Geometric s = shapes[index];
		return s.rightBorder();
	}

	public double bottomBorder(int index) {
		Geometric s = shapes[index];
		return s.bottomBorder();
	}

	public double leftBorder(int index) {
		Geometric s = shapes[index];
		return s.leftBorder();
	}

	public double area(int index) {
		Geometric s = shapes[index];
		return s.area();
	}

	public void move(int index, double dx, double dy) {
		Geometric s = shapes[index];
		s.move(dx, dy);
	}

	public void sortByArea() {

		Arrays.sort(shapes);

	}

	public void sortByX() {
	}

	public void sortByY() {
	}

	private void addToArray(Geometric g) {
		if (shapes == null) {
			shapes = new Geometric[1];
			shapes[0] = g;
		} else {
			shapes = Arrays.copyOf(shapes, shapes.length + 1);
			shapes[shapes.length - 1] = g;
		}

	}

}
