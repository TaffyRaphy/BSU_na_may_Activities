package Stack.Array.MP2;

public class Demo {
    public static void main(String[] args) {

        System.out.println("Part 1 Array Stack: ");
        System.out.println("\n1. Reversing a String");
        String s = "hola";
        String h = "data";
        String o = "spencer";

        ArrayStack stak = new ArrayStack(o.length());

        String result = stak.reverse(s);
        System.out.println("Original: " + s);
        System.out.println("Reverse: " + result);

        result = stak.reverse(h);
        System.out.println("\nOriginal: " + h);
        System.out.println("Reverse: " + result);

        result = stak.reverse(o);
        System.out.println("\nOriginal: " + o);
        System.out.println("Reverse: " + result);

        System.out.println("\n2. Trying to overflow the stack");

        ArrayStack ovfl = new ArrayStack(2);
        System.out.println("Attempting to push : 'h' \n.......");
        ovfl.push('h');
        System.out.println("(First push successful)");

        System.out.println("Attempting to push : 'e' \n.......");
        ovfl.push('e');
        System.out.println("(Second push successful)");

        System.out.println("Attempting to push : 'l' \n.......");
        ovfl.push('l');
        System.out.println("(Third push is not successful)");

        System.out.println("\n3. Trying to underflow the stack");
        ArrayStack udfl = new ArrayStack(1);
        udfl.pop();
        udfl.peek();
        System.out.println("(Pop and Peek failed)");
    }
}
