package FinalProject;

public class StudentEncap {
    private String id;
    private String lastName;
    private String firstName;
    private String middleName;
    private double gwa;

    public StudentEncap (String id, String lastName, String firstName, String middleName, double gwa){
        this.id= id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gwa = gwa;
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

    public double getGWA(){
        return gwa;
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

    public void setGWA (double gwa){
        this.gwa = gwa;
    }
    
    public String getFullName(){
        return firstName + " " + middleName + ". " + lastName;
    }

    public String getFullNameWithMiddleInitial(){
        return firstName + " " + middleName.substring(0,1) + ". " + lastName;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Full Name: " + getFullName() + ", GWA: " + gwa;
    }

    public String toCSV() {
        return id + "," + firstName + "," + middleName + "," + lastName + "," + gwa;
    }
}
