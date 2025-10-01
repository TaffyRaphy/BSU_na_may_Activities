package Queue.LinkedList;

public class LinkedListQueue {
    Node front = null;
    Node rear = null;

    public boolean isEmpty (){
        return front == null;
    }
    
    public void enqueue(String x){
        Node n = new Node(x);
        if (front == null){
            front = rear = n;
        } else{
            rear.next = n;
            rear = n;
        }
    }

    public String dequeue(){
        String item = front.value;
        front = front.next;
        
        if (front == null){
            rear = null;
        }
        return item;
    }
}