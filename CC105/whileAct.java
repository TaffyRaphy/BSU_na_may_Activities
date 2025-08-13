package CC105;

public class whileAct {
    public static void main(String[] args) {
        int rows = 5;
        int currentRow = 0, position, currentNumber;
        
        while (currentRow < rows){
            int spaces = 0;
            while (spaces < rows - currentRow - 1) {
                System.out.print(" ");
                spaces++;
            }
            
            position = 0;
            currentNumber = 1;
            
            while (position <= currentRow) {
                System.out.print(currentNumber + " ");
                currentNumber = currentNumber * (currentRow - position) / (position + 1);
                position++;
            }
            System.out.println();
            position++;
        }
    }
}