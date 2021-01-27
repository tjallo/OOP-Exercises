package student;

import java.util.Scanner;

/**
 * @author Tjalle Wolterink
 */

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        initzialize(scanner);

    }

    private static void initzialize(Scanner scanner) {
        System.out.println("Please enter the group size:");

        int groupSize = scanner.nextInt();
        scanner.nextLine();
        Group students = new Group(groupSize);

        inputStudents(scanner, groupSize, students);

    }

    private static void inputStudents(Scanner scanner, int groupSize, Group students) {
        for (int i = 1; i <= groupSize; i++) {
            System.out.println("Enter details for Student " + String.valueOf(i)
                    + " in form: {studentnumber} {firstName} {lastName}");

            String studentInput = scanner.nextLine();

            // Validating input
            if (studentInput.contains("-1")) {
                printGroup(students);
                System.out.println("\nBye!");
                break;
            }

            // Splitting input into different variables
            String[] splitInput = studentInput.split(" ");
            String firstName = splitInput[1];
            String lastName = splitInput[2];
            int sNumber = Integer.parseInt(splitInput[0]);

            // Adding student and printing all added students
            Student s = new Student(sNumber, firstName, lastName);
            students.addStudent(s);
            printGroup(students);
        }
    }

    private static void printGroup(Group students) {
        System.out.println("The group now contains: ");
        System.out.println(students.toString());
    }
}
