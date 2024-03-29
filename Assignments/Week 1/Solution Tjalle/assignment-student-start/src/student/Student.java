package student;

public class Student {
    private String firstName;
    private String lastName;
    private int sNumber;

    public Student(int sNumber, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sNumber = sNumber;
    }

    @Override
    public String toString() {
        // Lucy Liddels, s42
        if (firstName != null) {
            return firstName + " " + lastName + ", s" + String.valueOf(sNumber);
        }
        return "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void set_sNumber(int sNumber) {
        this.sNumber = sNumber;
    }

    public int get_sNumber() {
        return this.sNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
