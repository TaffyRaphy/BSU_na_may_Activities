package Stack.Array;

public class StackArray {
    int [] data;
    int top;
    int sizeniate;
    StackArray(int size){
        sizeniate = size;
        data = new int [size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == sizeniate - 1;
    }

    public void push (int x){
        if (isFull()){
            System.out.println("Overflow");
            return;
        }
        data [++top] = x;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        return data[top--];
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Underflow");
            return Integer.MIN_VALUE;
        }
        return data[top];
    }
}
