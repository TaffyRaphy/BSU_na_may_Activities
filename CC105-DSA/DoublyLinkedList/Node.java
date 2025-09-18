/**
 * Node class for Doubly Linked List
 * 
 * This class represents a single node in a doubly linked list.
 * Each node contains:
 * - data: the actual value stored in the node
 * - next: reference to the next node in the list
 * - prev: reference to the previous node in the list
 * 
 * Key Concepts:
 * - Unlike singly linked lists, doubly linked lists can traverse in both directions
 * - Each node maintains two pointers instead of one
 * - This allows for more efficient insertion and deletion operations
 */
public class Node {
    // Instance variables
    public int data;        // The data stored in this node
    public Node next;       // Reference to the next node
    public Node prev;       // Reference to the previous node
    
    /**
     * Constructor to create a new node with given data
     * @param data The integer value to store in this node
     */
    public Node(int data) {
        this.data = data;
        this.next = null;   // Initially, no next node
        this.prev = null;   // Initially, no previous node
    }
    
    /**
     * Constructor to create a node with data and references
     * @param data The integer value to store
     * @param prev Reference to the previous node
     * @param next Reference to the next node
     */
    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
    
    /**
     * String representation of the node (for debugging)
     * @return String containing the node's data
     */
    @Override
    public String toString() {
        return "Node{" + data + "}";
    }
}