package FinalProject;
//Encapsulation Class for Student's Data
public class StudentEncap {
    private String id; //Student's ID (Formatted with 2025XXX)
    private String lastName; //Student's Last Name
    private String firstName; //Student's First Name
    private String middleName; //Student's Middle Name
    private double gwa; //Student's General Weighted Average

    //Constructor for Student Encapsulation Class
    public StudentEncap (String id,String firstName, String middleName, String lastName, double gwa){
        this.id= id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gwa = gwa;
    }

    //Following is for getter method for student's data

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

    public double getGWA(){
        return gwa;
    }

    //Following is for setter method for student's data

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

    public void setGWA (double gwa){
        this.gwa = gwa;
    }
    
    //Concatenates Student's Names to form Student's Full Name
    public String getFullName(){
        return firstName + " " + middleName + " " + lastName;
    }

    //Concatenates Student's Names to form Student's Full Name With Middle Initial
    public String getFullNameWithMiddleInitial(){
        return firstName + " " + middleName.substring(0,1) + ". " + lastName;
    }

    @Override
    //Formats Student Data Display
    public String toString() {
        return "ID: " + id + ", Full Name: " + getFullName() + ", GWA: " + gwa;
    }

    //Formats Student Data to the CSV
    public String toCSV() {
        return id + "," + firstName + "," + middleName + "," + lastName + "," + gwa;
    }
}
