package Stack.LinkedList.MP2;

public class Demo {
    public static void main(String[] args) {
        Methods stack = new Methods();

        String wan = "({[]})";
        String tu = ")}][{(";
        String tree = "(){}[]";

        System.out.println("\n\nPart 2 LinkedList Stack:");
        
        System.out.println("1. Parentheses Checker");
        System.out.println("\nchecking \"" + wan + "\" if balanced");
        boolean balanceResult = stack.isBalanced(wan);

        System.out.println("result : " + (balanceResult ? "Balanced" : "Not Balanced"));

        System.out.println("\nchecking \"" + tu + "\" if balanced");
        balanceResult = stack.isBalanced(tu);

        System.out.println("result : " + (balanceResult ? "Balanced" : "Not Balanced"));

        System.out.println("\nchecking \"" + tree + "\" if balanced");
        balanceResult = stack.isBalanced(tree);

        System.out.println("result : " + (balanceResult ? "Balanced" : "Not Balanced"));

        System.out.println("\n2. Testing LinkedList Stack Underflow");

        stack.pop();
        stack.peek();
    }
}
