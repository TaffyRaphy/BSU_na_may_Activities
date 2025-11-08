package FinalProject;

public class StudentEncap {
    private String id;
    private String lastName;
    private String firstName;
    private String middleName;
    private double gpa;

    public StudentEncap (String id, String lastName, String firstName, String middleName, double gpa){
        this.id= id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gpa = gpa;
    }

    public String getId(){
        return id;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getMiddleName(){
        return middleName;
    }

    public double getGPA(){
        return gpa;
    }

    public void setId (String id){
        this.id = id;
    }

    public void setLastName (String lastName){
            this.lastName = lastName;
        }

    public void setFirstName (String firstName){
        this.firstName = firstName;
    }

    public void setMiddleName (String middleName){
        this.middleName = middleName;
    }

    public void setGPA (double gpa){
        this.gpa = gpa;
    }
    
    public String getFullName(){
        return firstName + " " + middleName + " " + lastName;
    }

    public String getFullNameWithMiddleInitial(){
        return firstName + " " + middleName.substring(0,1) + ". " + lastName;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + getFullName() + ", GPA: " + gpa;
    }

    public String toCSV() {
        return id + "," + firstName + "," + middleName + "," + lastName + "," + gpa;
    }
}
