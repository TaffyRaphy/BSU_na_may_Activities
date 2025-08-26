package Activity5;

import java.util.ArrayList;

public class RegistrationSystem {
    ArrayList<Student> students = new ArrayList<>(); // to store registred students

    // Add student
    public void addStudent(Student student) {
        for (Student find : students) { // find student ID to ensure it's unique
            if (find.getStudentId() == student.getStudentId()) {
                System.out.println("Student ID already exists");
            }
        }
        System.out.println("Your Student Added!");
        students.add(student);
    }

    // Remove ID
    public void removeStudent(int studentId) {
        int cout;
        boolean error = true;
        for (cout = 0; cout < students.size(); cout++) {
            if (students.get(cout).getStudentId() == studentId) {
                students.remove(cout);
                error = false;
                System.out.println("The student has been removed"); // Student is removed
            }
        }

        // If student does not exist
        if (error) {
            System.out.println("The student does not exist");
        }
    }

    // Display ALL
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("There are no students registered");
            return; // Break the method since there no students
        }

        int bilangko;
        System.out.println("Students registered");
        for (bilangko = 0; bilangko < students.size(); bilangko++) {
            System.out.println("Student #" + (bilangko + 1) + " out of " + students.size());
            students.get(bilangko).displayDetails();
        }
    }

    // Display details based on student ID
    public void findStudent(int studentId) {
        for (Student hanapStudent : students) {
            if (hanapStudent.getStudentId() == studentId) {
                hanapStudent.displayDetails();
                return;
            }
        }
    }

}
