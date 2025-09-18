package Stack.LinkedList;

public class StackLinkedList {
    Node top;

    public boolean isEmpty (){
        return top == null;
    }
    
    public void push(int x){
        Node n = new Node(x);
        n.next = top;
        top = n;
    }

    public int peek (){
        return (top != null) ? top.value : Integer.MIN_VALUE;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        int temp = top.value;
        top = top.next;
        return temp;
    }
}
