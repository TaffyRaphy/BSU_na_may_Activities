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
        if (head == null || saanPoba < 0) {
            return; // Invalid input or empty list
        }
        
        if (saanPoba == 0){
            head = head.next;
            if (head != null) {
                head.prev = null; // Update prev pointer for doubly linked list
            }
        } else {
            Node temp = head;
            
            // Traverse to the target position
            for (int i = 0; i < saanPoba && temp != null; i++){
                temp = temp.next;
            }
            
            if (temp == null) {
                return; // Position out of bounds
            }
            
            // Update the links
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }
    }

    public void deleteAtSingly(int saanPoba){
        if (head == null || saanPoba < 0) {
            return; // Invalid input or empty list
        }
        
        // If deleting the head node (position 0)
        if (saanPoba == 0){
            head = head.next;
            return;
        }
        
        // Find the node before the target position
        Node current = head;
        for (int i = 0; i < saanPoba - 1 && current != null; i++){
            current = current.next;
        }
        
        // If position is out of bounds
        if (current == null || current.next == null) {
            return;
        }
        
        // Skip the target node by updating the link
        current.next = current.next.next;
    }

    public int searchAt(int hahanapin){
        Node tagaHanap = head;
        int where = 0;
        while (tagaHanap != null) {
            if (tagaHanap.laman == hahanapin){
                return where;
            } else{
                tagaHanap = tagaHanap.next;
                where++;
            }
        }
        return -1;
    }

    public void bubbleSort() {
        if (head == null || head.next == null) {
            return;
        }
        
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            
            while (current.next != null) {
                if (current.laman > current.next.laman) {
                    int temp = current.laman;
                    current.laman = current.next.laman;
                    current.next.laman = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
