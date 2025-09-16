/**
 * Complete Doubly Linked List Implementation
 * 
 * This file contains all classes needed for a doubly linked list:
 * - Node class: Represents individual nodes
 * - DoublyLinkedList class: The main data structure
 * - Main class: Tutorial and demonstration
 * 
 * Author: Learning Tutorial
 * Date: September 2025
 */

/**
 * Node class for Doubly Linked List
 * 
 * Each node contains:
 * - data: the actual value stored in the node
 * - next: reference to the next node in the list
 * - prev: reference to the previous node in the list
 */
class Node {
    public int data;        // The data stored in this node
    public Node next;       // Reference to the next node
    public Node prev;       // Reference to the previous node
    
    /**
     * Constructor to create a new node with given data
     */
    public Node(int data) {
        this.data = data;
        this.next = null;   // Initially, no next node
        this.prev = null;   // Initially, no previous node
    }
    
    /**
     * String representation of the node
     */
    @Override
    public String toString() {
        return "Node{" + data + "}";
    }
}

/**
 * DoublyLinkedList class - A comprehensive implementation
 * 
 * This class demonstrates all essential operations of a doubly linked list
 */
class DoublyLinkedList {
    private Node head;      // Points to the first node
    private Node tail;      // Points to the last node
    private int size;       // Keeps track of the number of elements
    
    /**
     * Constructor - Initialize an empty list
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Check if the list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Get the size of the list
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Insert a new node at the beginning of the list
     * Time Complexity: O(1)
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            // First node in the list
            head = tail = newNode;
        } else {
            // Link new node to current head
            newNode.next = head;
            head.prev = newNode;
            head = newNode;     // Update head
        }
        size++;
        System.out.println("Inserted " + data + " at the beginning");
    }
    
    /**
     * Insert a new node at the end of the list
     * Time Complexity: O(1) - thanks to tail pointer
     */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            // First node in the list
            head = tail = newNode;
        } else {
            // Link new node to current tail
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;     // Update tail
        }
        size++;
        System.out.println("Inserted " + data + " at the end");
    }
    
    /**
     * Insert a new node at a specific position
     * Time Complexity: O(n) in worst case
     */
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position! Position should be between 0 and " + size);
            return;
        }
        
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        if (position == size) {
            insertAtEnd(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        
        // Navigate to the position
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        // Insert the new node
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        
        size++;
        System.out.println("Inserted " + data + " at position " + position);
    }
    
    /**
     * Delete the first occurrence of a value
     * Time Complexity: O(n)
     */
    public boolean delete(int data) {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return false;
        }
        
        Node current = head;
        
        // Find the node to delete
        while (current != null && current.data != data) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Value " + data + " not found in the list");
            return false;
        }
        
        // Case 1: Deleting the only node
        if (current == head && current == tail) {
            head = tail = null;
        }
        // Case 2: Deleting the head node
        else if (current == head) {
            head = head.next;
            head.prev = null;
        }
        // Case 3: Deleting the tail node
        else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // Case 4: Deleting a middle node
        else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        
        size--;
        System.out.println("Deleted " + data + " from the list");
        return true;
    }
    
    /**
     * Delete node at a specific position
     * Time Complexity: O(n)
     */
    public boolean deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position! Position should be between 0 and " + (size - 1));
            return false;
        }
        
        Node current = head;
        
        // Navigate to the position
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        int data = current.data;
        
        // Use the same deletion logic
        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        
        size--;
        System.out.println("Deleted " + data + " from position " + position);
        return true;
    }
    
    /**
     * Search for a value in the list
     * Time Complexity: O(n)
     */
    public int search(int data) {
        Node current = head;
        int position = 0;
        
        while (current != null) {
            if (current.data == data) {
                System.out.println("Found " + data + " at position " + position);
                return position;
            }
            current = current.next;
            position++;
        }
        
        System.out.println("Value " + data + " not found in the list");
        return -1;
    }
    
    /**
     * Display the list from head to tail (forward direction)
     */
    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        
        System.out.print("Forward: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    /**
     * Display the list from tail to head (backward direction)
     * This demonstrates the advantage of doubly linked lists!
     */
    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        
        System.out.print("Backward: ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println();
    }
    
    /**
     * Get the first element without removing it
     */
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        return head.data;
    }
    
    /**
     * Get the last element without removing it
     */
    public int getLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        return tail.data;
    }
    
    /**
     * Clear the entire list
     */
    public void clear() {
        head = tail = null;
        size = 0;
        System.out.println("List cleared!");
    }
    
    /**
     * Get a string representation of the list
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

/**
 * Main class - Doubly Linked List Tutorial and Demo
 * 
 * This demonstrates how to use the DoublyLinkedList class
 * and teaches key concepts about doubly linked lists
 */
public class DoublyLinkedListComplete {
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