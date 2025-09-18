package LinkedList.DoublyList;

public class Main {
    public static void main(String[] args) {
        Methods hi = new Methods();

        //insert data
        hi.insertSingly(10);
        hi.insertSingly(2);
        hi.insertSingly(11);
        hi.insertSingly(14);
        
        
        //1st question
        System.out.print("Forward: ");
        hi.traverseForward();

        System.out.print("\nBackward: ");
        hi.traverseBackward();
        

        
        //2nd question
        System.out.print("Before: ");
        hi.traverseForward();

        hi.deleteAt(1);

        System.out.print("\nAfter: ");
        hi.traverseForward();
        

        //3rd question
        System.out.println("Number 2 is found at " + hi.searchAt(2) + " index");

        //4th question
        System.out.print("Before: ");
        hi.traverseForward();

        hi.bubbleSort();

        System.out.print("\nAfter: ");
        hi.traverseForward();
        
        
    }
}
