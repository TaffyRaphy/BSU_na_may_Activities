package LinkedList.DoublyList;

public class Methods {
    Node head;

    public void insertDoubly(int data){
        Node bagongNode = new Node(data);
        if (head == null){
            head = bagongNode;
        } else{
            Node dabest = head;
            while(dabest.next != null){
                dabest = dabest.next;
            }
            dabest.next = bagongNode;
            bagongNode.prev = dabest;
        }
    }

    public void insertSingly(int data){
        Node bagongNode = new Node(data);
        if (head == null){
            head = bagongNode;
        } else{
            Node dabest = head;
            while(dabest.next != null){
                dabest = dabest.next;
            }
            dabest.next = bagongNode;
        }
    }

    public void traverseForward(){
        Node paPrintPO = head;
        System.out.print("[");
        while(paPrintPO != null){
            System.out.print(paPrintPO.laman);
            paPrintPO = paPrintPO.next;
            if(paPrintPO != null){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public void traverseBackward(){
        Node last = head; 
        while (last.next != null) {
            last = last.next;
        }

        Node paPrintPO = last;
        System.out.print("[");
        while(paPrintPO != null){
            System.out.print(paPrintPO.laman);
            paPrintPO = paPrintPO.prev;
            if(paPrintPO != null){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public void deleteAt(int saanPoba){
        if (saanPoba == 0){
            head = head.next;
        } else{
                Node temp = head;
                Node ibaNaIturo = null;
                for (int i = 0; i < saanPoba; i++){
                    temp = temp.next;
                }
                ibaNaIturo = temp.next;
                temp.next = ibaNaIturo.next;
        }
    }
}
