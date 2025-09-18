package Stack.LinkedList.MP2;

public class Demo {
    public static void main(String[] args) {
        Methods stack = new Methods();

        String balanced = "({[]})";
        String unbalanced = ")}][{(";

        System.out.println("Parentheses Checker!");

        System.out.println("checking \"" + balanced + "\" if balanced");
        boolean result = stack.isBalanced(balanced);

        System.out.println("result : " + (result ? "Balanced" : "Not Balanced"));

        System.out.println("\nchecking \"" + unbalanced + "\" if balanced");
        result = stack.isBalanced(unbalanced);

        System.out.println("result : " + (result ? "Balanced" : "Not Balanced"));

        System.out.println("\nTesting LinkedList Stack Underflow");

        stack.pop();
        stack.peek();
    }
}
