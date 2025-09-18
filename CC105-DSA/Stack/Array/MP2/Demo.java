package Stack.Array.MP2;

public class Demo {
    public static void main(String[] args) {

        System.out.println("1. Reversing a String");
        String s = "Stack";
        ArrayStack stak = new ArrayStack(s.length());
        for (char c : s.toCharArray()){
            stak.push(c);
        }

        String result = "";
        while (!stak.isEmpty()) {
            result += stak.pop();
        }

        System.out.println("Original: " + s);
        System.out.println("Reverse: " + result);

        System.out.println("\n2. Trying to overflow the stack");

        ArrayStack ovfl = new ArrayStack(2);
        System.out.println("Attempting to push : 'h' \n.......");
        ovfl.push('h');
        System.out.println("First push successful");

        System.out.println("Attempting to push : 'e' \n.......");
        ovfl.push('e');
        System.out.println("Second push successful");

        System.out.println("Attempting to push : 'l' \n.......");
        ovfl.push('l');
        System.out.println("Third push is not successful");


        System.out.println("\n3. Trying to underflow the stack");
        ArrayStack udfl = new ArrayStack(1);
        udfl.pop();
        udfl.peek();
        System.out.println("Pop and Peek failed");
    }
}
