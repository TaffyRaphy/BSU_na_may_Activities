package Stack.Array.MP2;

public class ArrayStack {
    char[] data;
    int top = -1;
    int size;
    
    ArrayStack(int n){
        size = n;
        data = new char [n];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size - 1;
    }

    public char peek(){
        if (isEmpty()){
            System.out.println("Stack is empty! Nothing to peek");
            return '\0';
        }
        return data[top];
    }
    public void push (char c){
        if (isFull()){
            System.out.println("Stack Overflow! Cannot push");
            return;
        }
        data [++top] = c;
    }

    public char pop(){
        if (isEmpty()){
            System.out.println("Stack Underflow! Cannot pop from empty stack");
            return '\0';
        }
        return data[top--];
    }
}
