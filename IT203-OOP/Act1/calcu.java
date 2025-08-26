package Act1;

public class calcu {
   int number1;
   int number2;

   public void addNumbers(int number1, int number2){
       this.number1 = number1;
       this.number2 = number2;

       System.out.println("Sum \t\t: \t" + (number1 + number2));
   }

   public void subtractNumbers(int number1, int number2){
       this.number1 = number1;
       this.number2 = number2;

       System.out.println("Difference \t: \t" + (number1 - number2));
   }

    public void multiplyNumbers(int number1, int number2){
       this.number1 = number1;
       this.number2 = number2;

       System.out.println("Product \t: \t" + (number1 * number2));
   }
}