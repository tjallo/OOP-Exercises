package student;

public class Group {
    private Student[] students;

    public Group(int size) {
        this.students = new Student[size];
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            } 
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (Student student : students) {
            if (student != null) {
                s += student.toString() + "\n";
            }
        }
        return s;
    }

    public void changeStudent(int sNumber, String firstName, String lastName) {
        Student newStudent = new Student(sNumber, firstName, lastName);
        for (int i = 0; i < students.length; i++) {
            if (students[i].get_sNumber() == sNumber) {
                students[i] = newStudent;
            }
        }
	}

}
