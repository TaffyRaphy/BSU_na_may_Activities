package inheritance;

public class chicken extends animal{
    String type;
    int eggsPerWeek;
    boolean canFly;
    String coopLocation;
    double wingspan;
    
    chicken(String name, int age, int legs, String color, String type, int eggsPerWeek, boolean canFly, String coopLocation, double wingspan){
        super(name, age, legs, color);
        this.type = type;
        this.eggsPerWeek = eggsPerWeek;
        this.canFly = canFly;
        this.coopLocation = coopLocation;
        this.wingspan = wingspan;
    }
    
    void displayChickenInfo(){
        displayInfo();
        System.out.println("Role in the farm: " + type);
        System.out.println("Eggs Per Week: " + eggsPerWeek);
        System.out.println("Can Fly: " + (canFly ? "Yes" : "No"));
        System.out.println("Coop Location: " + coopLocation);
        System.out.println("Wingspan: " + wingspan + " cm");
    }
}