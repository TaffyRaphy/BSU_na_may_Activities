package LinkedList.DoublyList;

public class Main {
    public static void main(String[] args) {
        Methods hi = new Methods();

        hi.insertSingly(10);
        hi.insertSingly(2);
        hi.insertSingly(11);
        hi.insertSingly(14);
        
        /* 
        System.out.print("Forward: ");
        hi.traverseForward();

        System.out.print("\nBackward: ");
        hi.traverseBackward();
        */

        System.out.print("Before: ");
        hi.traverseForward();

        hi.deleteAt(1);

        System.out.print("\nAfter: ");
        hi.traverseForward();

    }
}
