package inheritance;

public class animal {
    String name;
    int age;
    int legs;
    String color;
    
    animal(String name, int age, int legs, String color){
        this.name = name;
        this.age = age;
        this.legs = legs;
        this.color = color;
    }
   
    void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Color: " + color);
        System.out.println("Number of legs: " + legs);
    }
}