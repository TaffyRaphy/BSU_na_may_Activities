// Node class - represents individual elements in the linked list
class Node<T> {
    T data;
    Node<T> next;
    
    // Constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class - contains all the methods for linked list operations
class LinkedList<T> {
    private Node<T> head;
    private int size;
    
    // Constructor
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Add element to the beginning of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // Add element to the end of the list
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    // Add element at specific index
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    // Remove first element
    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    // Remove last element
    public T removeLast() {
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }
    
    // Remove element at specific index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            return removeFirst();
        }
        
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }
    
    // Get element at specific index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Find index of element
    public int indexOf(T data) {
        Node<T> current = head;
        int index = 0;
        
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Not found
    }
    
    // Check if list contains element
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
    
    // Get size of the list
    public int size() {
        return size;
    }
    
    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Clear the list
    public void clear() {
        head = null;
        size = 0;
    }
    
    // Convert list to string
    public String toString() {
        if (head == null) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        
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

// Main class - demonstrates the linked list functionality
public class LinkedListDemo {
    public static void main(String[] args) {
        // Create a new LinkedList of Integers
        LinkedList<Integer> list = new LinkedList<>();
        
        System.out.println("=== LinkedList Demo ===");
        System.out.println("Initial list: " + list);
        System.out.println("Is empty: " + list.isEmpty());
        System.out.println();
        
        // Adding elements
        System.out.println("Adding elements...");
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.add(1, 15); // Insert 15 at index 1
        
        System.out.println("After adding elements: " + list);
        System.out.println("Size: " + list.size());
        System.out.println();
        
        // Accessing elements
        System.out.println("Accessing elements...");
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Index of 20: " + list.indexOf(20));
        System.out.println("Contains 25: " + list.contains(25));
        System.out.println("Contains 30: " + list.contains(30));
        System.out.println();
        
        // Removing elements
        System.out.println("Removing elements...");
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("After removing first: " + list);
        
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("After removing last: " + list);
        
        System.out.println("Removed at index 1: " + list.remove(1));
        System.out.println("After removing at index 1: " + list);
        System.out.println();
        
        // Working with String LinkedList
        System.out.println("=== String LinkedList Demo ===");
        LinkedList<String> stringList = new LinkedList<>();
        
        stringList.addLast("Apple");
        stringList.addLast("Banana");
        stringList.addFirst("Cherry");
        stringList.add(2, "Date");
        
        System.out.println("String list: " + stringList);
        System.out.println("First fruit: " + stringList.get(0));
        System.out.println("Last fruit: " + stringList.get(stringList.size() - 1));
        
        // Clear the list
        stringList.clear();
        System.out.println("After clearing: " + stringList);
        System.out.println("Is empty: " + stringList.isEmpty());
    }
}