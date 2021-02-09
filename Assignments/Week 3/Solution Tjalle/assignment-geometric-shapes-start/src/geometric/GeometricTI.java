package geometric;

import java.util.ArrayList;
import java.util.Scanner;

public class GeometricTI {

    private ArrayList<Geometric> shapes = new ArrayList<Geometric>();
    private Scanner scanner;

    public GeometricTI() {
        scanner = new Scanner(System.in);
        System.out.println("Available commands:\nquit\nshow\ncircle\nrectangle\nmove\nremove");
    }

    public void start() {
        System.out.print("\nEnter a command: ");
        String command = scanner.next();
        scanner.close();
        commandParser(command);
    }

    public void commandParser(String command) {

        switch (command) {
            case "quit":

                quit();

            case "show":
                show();

            case "circle":
                circle();
            case "rectangle":
                rectangle();
            case "move":
                move();
            case "remove":
                remove();
                // case "sort":
                // sort(c);

            default:
                System.out.println("Invalid command entered.");
                start();
        }
    }

    public void quit() {
    }

    public void show() {
        if (shapes.size() < 1) {
            System.out.println("The shape array is empty.");
        } else {
            for (int i = 0; i < shapes.size(); i++) {
                Geometric g = shapes.get(i);
                System.out.println(Integer.toString(i) + ": " + g.toString());
            }
        }
    }

    public void circle() {
        double x, y, r;

    }

    public void rectangle() {
        double x, y, width, heigth;
    }

    public void move() {
        double dx, dy;
    }

    public void remove() {
        int i;
    }

    public void sort() {
        char c;
    }

}
