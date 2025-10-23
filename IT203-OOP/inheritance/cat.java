package inheritance;

public class cat extends animal{
    String breed;
    String foodPreference;
    boolean isIndoor;
    double weight;
    String favoriteActivity;
    
    cat(String name, int age, int legs, String color, String breed, String foodPreference, boolean isIndoor, double weight, String favoriteActivity){
        super(name, age, legs, color);
        this.breed = breed;
        this.foodPreference = foodPreference;
        this.isIndoor = isIndoor;
        this.weight = weight;
        this.favoriteActivity = favoriteActivity;
    }
    
    void displayCatInfo(){
        displayInfo();
        System.out.println("Breed: " + breed);
        System.out.println("Food Preference: " + foodPreference);
        System.out.println("Indoor Cat: " + (isIndoor ? "Yes" : "No"));
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Favorite Activity: " + favoriteActivity);
    }
}