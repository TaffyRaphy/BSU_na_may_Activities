package Stack.LinkedList.MP2;

public class Methods {
    Node top;

    public boolean isEmpty (){
        return top == null;
    }
    
    public void push(String x){
        Node n = new Node(x);
        n.next = top;
        top = n;
    }

    public String peek (){
        if (top == null) {
            System.out.println("Stack is empty! Nothing to peek");
            return null;
        }
        return top.value;
    }

    public String pop(){
        if (isEmpty()){
            System.out.println("Stack Underflow! Cannot pop from empty stack");
            return null;
        }
        String temp = top.value;
        top = top.next;
        return temp;
    }

    public boolean isBalanced(String input){
        top = null;
        
        for (int i = 0; i < input.length(); i++){
            char check = input.charAt(i);

            if (check == '(' || check == '[' || check == '{') {
                push(Character.toString(check));
            } else if (check == ')' || check == ']' || check == '}'){
                if (isEmpty()){
                    return false;
                }

                String topValue = pop();
                if(topValue.equals("(") && check != ')'||
                   topValue.equals("{") && check != '}'||
                   topValue.equals("[") && check != ']') {
                    return false;
                }
            }
        }
        return isEmpty();
    }
}
