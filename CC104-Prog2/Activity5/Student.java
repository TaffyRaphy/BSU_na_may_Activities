package Activity5;

public class Student {
    String name;
    int studentId;
    double gpa;

    // Constructor to set the student attributes
    public Student(String name, int studentId, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.gpa = gpa;
    }

    // get the studentID
    public int getStudentId() {
        return studentId;
    }

    // Method to display the student details correctly instead of it being gibberish
    public void displayDetails() {
        System.out.println("Name: " + name +
                "\nID : " + studentId +
                "\nGPA: " + gpa);
    }
}
