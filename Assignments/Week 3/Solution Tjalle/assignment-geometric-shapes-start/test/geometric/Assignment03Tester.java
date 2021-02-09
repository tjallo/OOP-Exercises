package geometric;

import java.util.ArrayList;

public class Assignment03Tester {
	private Circle c;
	private Rectangle r;

	private ArrayList<Geometric> shapes;
	private Sort sorter;

	public Assignment03Tester() {
		shapes = new ArrayList<Geometric>();
		sorter = new Sort();
	}

	public void createCircle(double x, double y, double r) {
		c = new Circle(x, y, r);
		shapes.add(c);
	}

	public void createRectangle(double x, double y, double width, double height) {
		r = new Rectangle(x, y, width, height);
		shapes.add(r);
	}

	public double topBorder(int index) {
		Geometric s = shapes.get(index);
		return s.topBorder();
	}

	public double rightBorder(int index) {
		Geometric s = shapes.get(index);
		return s.rightBorder();
	}

	public double bottomBorder(int index) {
		Geometric s = shapes.get(index);
		return s.bottomBorder();
	}

	public double leftBorder(int index) {
		Geometric s = shapes.get(index);
		return s.leftBorder();
	}

	public double area(int index) {
		Geometric s = shapes.get(index);
		return s.area();
	}

	public void move(int index, double dx, double dy) {
		Geometric s = shapes.get(index);
		s.move(dx, dy);
	}

	public void sortByArea() {

		shapes = sorter.sortByArea(shapes);

	}

	public void sortByX() {
	}

	public void sortByY() {
	}
}
