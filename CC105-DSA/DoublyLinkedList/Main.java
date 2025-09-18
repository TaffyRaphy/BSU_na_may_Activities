/**
 * Main class - Doubly Linked List Tutorial and Demo
 * 
 * This class demonstrates how to use the DoublyLinkedList class
 * and teaches key concepts about doubly linked lists through examples.
 * 
 * Learning Goals:
 * 1. Understand how doubly linked lists work
 * 2. See the difference between singly and doubly linked lists
 * 3. Learn when to use doubly linked lists
 * 4. Practice with common operations
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DOUBLY LINKED LIST TUTORIAL ===\n");
        
        // Create a new doubly linked list
        DoublyLinkedList dll = new DoublyLinkedList();
        
        // Lesson 1: Basic Operations
        System.out.println("LESSON 1: Basic Insert Operations");
        System.out.println("----------------------------------");
        
        System.out.println("Starting with an empty list:");
        dll.displayForward();
        System.out.println("Size: " + dll.getSize() + "\n");
        
        // Insert at beginning
        System.out.println("Inserting elements at the beginning:");
        dll.insertAtBeginning(10);
        dll.insertAtBeginning(20);
        dll.insertAtBeginning(30);
        dll.displayForward();
        dll.displayBackward();
        System.out.println("Size: " + dll.getSize() + "\n");
        
        // Insert at end
        System.out.println("Inserting elements at the end:");
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.displayForward();
        dll.displayBackward();
        System.out.println("Size: " + dll.getSize() + "\n");
        
        // Lesson 2: Position-based Operations
        System.out.println("LESSON 2: Position-based Operations");
        System.out.println("-----------------------------------");
        
        System.out.println("Current list:");
        dll.displayForward();
        
        System.out.println("\nInserting at specific positions:");
        dll.insertAtPosition(35, 4);  // Insert 35 at position 4
        dll.insertAtPosition(5, 0);   // Insert 5 at beginning (position 0)
        dll.insertAtPosition(60, dll.getSize()); // Insert 60 at end
        
        dll.displayForward();
        dll.displayBackward();
        System.out.println("Size: " + dll.getSize() + "\n");
        
        // Lesson 3: Search Operations
        System.out.println("LESSON 3: Search Operations");
        System.out.println("---------------------------");
        
        System.out.println("Current list:");
        dll.displayForward();
        
        System.out.println("\nSearching for values:");
        dll.search(35);
        dll.search(5);
        dll.search(100);  // This won't be found
        System.out.println();
        
        // Lesson 4: Access Operations
        System.out.println("LESSON 4: Access Operations");
        System.out.println("---------------------------");
        
        try {
            System.out.println("First element: " + dll.getFirst());
            System.out.println("Last element: " + dll.getLast());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        
        // Lesson 5: Deletion Operations
        System.out.println("LESSON 5: Deletion Operations");
        System.out.println("-----------------------------");
        
        System.out.println("Current list:");
        dll.displayForward();
        
        System.out.println("\nDeleting by value:");
        dll.delete(35);
        dll.delete(5);
        dll.delete(100);  // This won't be found
        
        dll.displayForward();
        dll.displayBackward();
        System.out.println("Size: " + dll.getSize() + "\n");
        
        System.out.println("Deleting by position:");
        dll.deleteAtPosition(0);  // Delete first element
        dll.deleteAtPosition(dll.getSize() - 1);  // Delete last element
        dll.deleteAtPosition(1);  // Delete middle element
        
        dll.displayForward();
        dll.displayBackward();
        System.out.println("Size: " + dll.getSize() + "\n");
        
        // Lesson 6: Edge Cases
        System.out.println("LESSON 6: Edge Cases and Error Handling");
        System.out.println("---------------------------------------");
        
        System.out.println("Testing invalid operations:");
        dll.insertAtPosition(999, -1);    // Invalid position
        dll.insertAtPosition(999, 100);   // Position too large
        dll.deleteAtPosition(-1);         // Invalid position
        dll.deleteAtPosition(100);        // Position too large
        System.out.println();
        
        // Clear the list and test empty list operations
        System.out.println("Testing empty list operations:");
        dll.clear();
        dll.displayForward();
        dll.displayBackward();
        dll.delete(10);
        dll.search(10);
        
        try {
            dll.getFirst();
        } catch (RuntimeException e) {
            System.out.println("Error accessing first element of empty list: " + e.getMessage());
        }
        
        try {
            dll.getLast();
        } catch (RuntimeException e) {
            System.out.println("Error accessing last element of empty list: " + e.getMessage());
        }
        System.out.println();
        
        // Lesson 7: Advantages of Doubly Linked Lists
        System.out.println("LESSON 7: Advantages of Doubly Linked Lists");
        System.out.println("-------------------------------------------");
        
        // Rebuild a small list for demonstration
        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.insertAtEnd(4);
        dll.insertAtEnd(5);
        
        System.out.println("Created list for demonstration:");
        dll.displayForward();
        
        System.out.println("\nAdvantages of Doubly Linked Lists:");
        System.out.println("1. Bidirectional traversal:");
        System.out.print("   ");
        dll.displayForward();
        System.out.print("   ");
        dll.displayBackward();
        
        System.out.println("2. Efficient deletion when you have a reference to the node");
        System.out.println("3. Easier implementation of certain algorithms");
        System.out.println("4. Can traverse backwards without recursion");
        
        System.out.println("\nDisadvantages:");
        System.out.println("1. Extra memory for previous pointers");
        System.out.println("2. More complex insertion/deletion code");
        System.out.println("3. More pointer manipulations = more chances for bugs");
        System.out.println();
        
        // Final demonstration
        System.out.println("FINAL DEMONSTRATION");
        System.out.println("-------------------");
        
        System.out.println("Final list state:");
        System.out.println("toString() representation: " + dll.toString());
        dll.displayForward();
        dll.displayBackward();
        System.out.println("Size: " + dll.getSize());
        System.out.println("Is empty: " + dll.isEmpty());
        
        System.out.println("\n=== TUTORIAL COMPLETE ===");
        System.out.println("You've learned about:");
        System.out.println("✓ Node structure with prev and next pointers");
        System.out.println("✓ Insertion at beginning, end, and arbitrary positions");
        System.out.println("✓ Deletion by value and position");
        System.out.println("✓ Searching and accessing elements");
        System.out.println("✓ Bidirectional traversal");
        System.out.println("✓ Edge cases and error handling");
        System.out.println("✓ Advantages and disadvantages");
        
        System.out.println("\nNext steps for practice:");
        System.out.println("1. Try implementing a generic version (DoublyLinkedList<T>)");
        System.out.println("2. Add iterator support for enhanced for loops");
        System.out.println("3. Implement additional methods like reverse(), sort(), etc.");
        System.out.println("4. Create a circular doubly linked list variation");
        System.out.println("5. Compare performance with ArrayList and LinkedList");
    }
}