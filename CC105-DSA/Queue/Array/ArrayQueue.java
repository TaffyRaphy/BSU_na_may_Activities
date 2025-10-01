package Queue.Array;

public class ArrayQueue {
    char[] data;
    int front = -1;
    int rear = -1;
    int size;
    
    ArrayQueue(int n){
        size = n;
        data = new char [n];
        front = 0;
    }

    public void enqueue(char n){
        data[++rear] = n;
    }

    public char dequeue(){
        char item = data [front];
        
        if (front == rear){
            front = -1;
            rear = -1;
        } else{
            front++;
        }

        return item;
    }
    
    public char peek(){
        return data[front];
    }
}