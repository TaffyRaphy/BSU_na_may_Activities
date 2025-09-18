class Node {
    int data;    // The value stored in this node
    Node next;   // Reference to the next node in the list
    
    // Constructor to create a new node with given data
    public Node(int data) {
        this.data = data;
        this.next = null; // Initially, next points to nothing
    }
}

public class selfstudy_linkedList {
    public static void main(String[] args) {
        Node head = new Node(10);

        Node second = new Node (20);
        Node third = new Node(30);

        head.next = second;
        second.next = third;

        printList(head);
    }

    public static void printList (Node node){
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
