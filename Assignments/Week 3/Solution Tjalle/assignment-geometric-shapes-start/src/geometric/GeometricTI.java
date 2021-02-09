package geometric;

import java.util.ArrayList;
import java.util.Scanner;

public class GeometricTI {

    private ArrayList<Geometric> shapes = new ArrayList<Geometric>();
    private Sort sorter = new Sort();
    private Scanner scanner;

    public GeometricTI() {
        scanner = new Scanner(System.in);
        System.out.println("Available commands:\nquit\nshow\nsort\ncircle\nrectangle\nmove\nremove");
    }

    public void start() {
        System.out.print("Enter a command: ");
        String command = scanner.next();
        commandParser(command);
    }

    private void commandParser(String command) {

        switch (command) {
            case "quit":
                quit();
                break;
            case "show":
                show();
                break;
            case "circle":
                circle();
                break;
            case "sort":
                sort();
                break;
            case "rectangle":
                rectangle();
                break;
            case "move":
                move();
                break;
            case "remove":
                remove();
                break;
            // case "sort":
            // sort(c);

            default:
                System.out.println("Invalid command entered.");
                start();
                break;
        }
    }

    private void quit() {
        System.out.println("Quitting...");
    }

    private void show() {
        if (shapes.size() < 1) {
            System.out.println("The shape array is empty.");
        } else {
            printEntries();
        }

        start();
    }

    private void printEntries() {
        for (int i = 0; i < shapes.size(); i++) {
            Geometric g = shapes.get(i);
            System.out.println(Integer.toString(i) + ": " + g.toString());
        }
    }

    private void circle() {
        double x, y, r;

        System.out.print("Enter the x-pos the Circle should be at: ");
        x = scanner.nextDouble();
        System.out.print("Enter the y-pos the Circle should be at: ");
        y = scanner.nextDouble();
        System.out.print("Enter the radius the circle should have: ");
        r = scanner.nextDouble();

        Circle c = new Circle(x, y, r);
        shapes.add(c);

        System.out.println("Added circle: " + c.toString());

        start();

    }

    private void rectangle() {
        double x, y, width, heigth;

        System.out.print("Enter the x-pos the Rectangle should be at: ");
        x = scanner.nextDouble();
        System.out.print("Enter the y-pos the Rectangle should be at: ");
        y = scanner.nextDouble();
        System.out.print("Enter the width the Rectangle should be at: ");
        width = scanner.nextDouble();
        System.out.print("Enter the heigth the Rectangle should be at: ");
        heigth = scanner.nextDouble();

        Rectangle r = new Rectangle(x, y, width, heigth);
        shapes.add(r);

        System.out.println("Added rectangle: " + r.toString());

        start();
    }

    private void move() {
        double dx, dy;

        if (shapes.size() < 1) {
            System.out.println("The array is  empty. You can't move any items.");
        } else {
            printEntries();
            System.out.print("Enter the index of the item you want moved: ");
            int index = scanner.nextInt();

            Geometric g = shapes.get(index);

            System.out.print("Move by dX: ");
            dx = scanner.nextDouble();
            System.out.print("Move by dY: ");
            dy = scanner.nextDouble();

            double orgX = g.getXval();
            double orgY = g.getYval();

            g.move(dx, dy);

            double newX = g.getXval();
            double newY = g.getYval();

            shapes.set(index, g);

            System.out.println("Moved Shape at index " + Integer.toString(index) + " from [" + Double.toString(orgX)
                    + "," + Double.toString(orgY) + "] to [" + Double.toString(newX) + "," + Double.toString(newY)
                    + "]");
        }

        start();
    }

    private void remove() {

        if (shapes.size() < 1) {
            System.out.println("The array is already empty. You can't remove any items.");
        } else {
            printEntries();
            System.out.print("Enter the index of the item you want removed: ");
            int index = scanner.nextInt();
            Geometric removed = shapes.get(index);
            shapes.remove(index);
            System.out.println("Removed: " + removed.toString());
        }

        start();
    }

    private void sort() {
        if (shapes.size() < 1) {
            System.out.println("The array is empty. You can't sort an empty array.");
        } else if (shapes.size() == 1) {
            System.out.println("The array only has one entry, sorting wil have no effect.");
        } else {
            System.out.println("Sort by:\nx values: x\ny values: y\narea: a");
            String input = scanner.next();
            parseSort(input);
        }

        start();
    }

    private void parseSort(String input) {
        if (!input.equals("")) {
            if (input.charAt(0) == 'x') {
                // TODO: Implement sorter
                System.out.println("Sorted by x values");
            } else if (input.charAt(0) == 'y') {
                // TODO: Implement sorter
                System.out.println("Sorted by y values");

            } else {
                shapes = sorter.sortByArea(shapes);
                System.out.println("Sorted by Area.");
            }
        } else {
            shapes = sorter.sortByArea(shapes);
            System.out.println("Sorted by Area.");
        }
        printEntries();

    }

}
