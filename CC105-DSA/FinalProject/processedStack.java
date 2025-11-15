package FinalProject;
//Stack for Processed Request Class
public class processedStack {
    private proStackNode top;
    private int size;

    //Constructor for processedStack Class
    public processedStack(){
        this.top = null;
        this.size = 0;
    }

    //Pushes the stack 
    public void push(String request, StudentEncap student){
        StudentEncap studentCopy = new StudentEncap(student.getId(), student.getFirstName(), student.getMiddleName(), student.getLastName(), student.getGWA());
        proStackNode newNode = new proStackNode(request, studentCopy);
        newNode.next = top;
        top = newNode;
        size++;
    }

    //Pops the stack
    public proStackNode pop(){
        if (top == null){
            System.out.println("Stack is empty! Nothing to undo");
            return null;
        }

        proStackNode temp = top;
        top = top.next;
        size--;
        return temp;
    }
    
    //Displays the Stack
    public void display(){
        if (top == null){
            System.out.println("No Requests Stored in history");
            return;
        }

        System.out.println("====Request History====");
        proStackNode current = top;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.request + " - " + current.studentData);
            current = current.next;
            position++;
        }
    }

    //Checks if the stack is empty
    public boolean isEmpty(){
        return top == null;
    }

    //Gets the size of the stack
    public int getSize(){
        return size;
    }
    
    //Clears the stack
    public void clear() {
        top = null;
        size = 0;
    }
}
