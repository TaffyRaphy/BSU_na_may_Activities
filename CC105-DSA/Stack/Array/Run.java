package Stack.Array;

public class Run {
    public static void main(String[] args) {
        StackArray sArr = new StackArray(10);

        System.out.println(sArr.peek());
        
        sArr.push(2);
        sArr.push(2);
        sArr.push(4);        
        sArr.push(9); 
        sArr.push(2); 

        System.out.println(sArr.peek());

        sArr.pop();
        sArr.pop();

        System.out.println(sArr.peek());
    }
}
