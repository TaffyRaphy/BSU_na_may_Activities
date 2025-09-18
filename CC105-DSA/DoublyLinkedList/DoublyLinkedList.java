/**
 * DoublyLinkedList class - A comprehensive implementation
 * 
 * This class demonstrates all essential operations of a doubly linked list:
 * - Insertion (at beginning, end, and specific positions)
 * - Deletion (by value and by position)
 * - Search operations
 * - Display in both directions
 * - Size management
 * 
 * Learning Objectives:
 * - Understand pointer manipulation in both directions
 * - Learn about edge cases (empty list, single element, etc.)
 * - Practice memory management concepts
 * - See the advantages of bidirectional traversal
 */
public class DoublyLinkedList {
    private Node head;      // Points to the first node
    private Node tail;      // Points to the last node (for efficient insertion at end)
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
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Get the size of the list
     * @return number of elements in the list
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Insert a new node at the beginning of the list
     * Time Complexity: O(1)
     * 
     * @param data The value to insert
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
     * 
     * @param data The value to insert
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
     * 
     * @param data The value to insert
     * @param position The position to insert at (0-based indexing)
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
     * 
     * @param data The value to delete
     * @return true if deleted successfully, false if not found
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
     * 
     * @param position The position to delete from (0-based indexing)
     * @return true if deleted successfully, false otherwise
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
        
        // Use the same deletion logic as delete(int data)
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
     * 
     * @param data The value to search for
     * @return the position of the value (0-based), -1 if not found
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
     * @return the data in the first node, or throws exception if empty
     */
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        return head.data;
    }
    
    /**
     * Get the last element without removing it
     * @return the data in the last node, or throws exception if empty
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
     * @return String representation of the list
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