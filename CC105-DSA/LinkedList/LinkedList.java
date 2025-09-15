package LinkedList;                          // Declares this class belongs to the LinkedList package

public class LinkedList {                    // Defines a public class named LinkedList - represents the entire linked list structure
    Node ulo;                               // Head pointer - points to the first node in the linked list (ulo = "head" in Filipino)

    // Method to insert a new element at the end of the linked list
    public void insert(int angLalagay){     // Method declaration with parameter angLalagay = "what will be placed" in Filipino
        Node bagongNode = new Node();       // Create a new Node object in memory (bagongNode = "new node" in Filipino)
        bagongNode.laman = angLalagay;      // Set the data/content of the new node (laman = "content" in Filipino)
        bagongNode.susunod = null;          // Set the next pointer to null since it will be the last node (susunod = "next" in Filipino)

        if (ulo == null){                   // Check if the list is empty (no head node exists)
            ulo = bagongNode;               // If empty, make the new node the head of the list

        } else{                             // If the list is not empty (has at least one node)
            Node n = ulo;                   // Create a temporary pointer/reference starting at the head
            while(n.susunod != null){       // Traverse to find the last node (while current node's next is not null)
                n = n.susunod;              // Move the pointer to the next node in the chain
            }
            n.susunod = bagongNode;         // Link the last node to the new node (connecting them)
        }
    }

    public void insertAtStart (int angLalagay){    // Method to insert a new element at the beginning of the list
        Node bagongSimula = new Node();            // Create a new Node object (bagongSimula = "new beginning" in Filipino)
        bagongSimula.laman = angLalagay;           // Set the data/content of the new node
        bagongSimula.susunod = null;               // Initialize next pointer to null (will be updated next)

        bagongSimula.susunod = ulo;                // Point the new node's next to the current head (old first node)
        ulo = bagongSimula;                        // Update head pointer to point to the new node (making it the new first node)
    }

    public void insertAtLocation (int address, int angLalagay){  // Method to insert at a specific position in the list
        if (address == 0){                         // Check if user wants to insert at position 0 (beginning)
            System.out.println("bobo kaba? edi gamitin mo ung 'start at' method");  // Print sarcastic message telling user to use insertAtStart instead
            insertAtStart(angLalagay);             // Call the insertAtStart method instead
            return;                                // Exit the method early
        }
        
        Node paSingit = new Node();                // Create a new Node object (paSingit = "to insert/squeeze in" in Filipino)
        paSingit.laman = angLalagay;               // Set the data/content of the new node
        paSingit.susunod = null;                   // Initialize next pointer to null

        Node n = ulo;                              // Create a temporary pointer starting at the head
        for (int i = 0; i < address - 1; i++){    // Loop to reach the node just before the insertion point
            n = n.susunod;                         // Move to the next node (traversing the list)
        }
        paSingit.susunod = n.susunod;              // Point new node's next to the node that comes after the insertion position
        n.susunod = paSingit;                      // Point the previous node's next to the new node (inserting it into the chain)
    }

    // Method to print all elements in the linked list
    public void print (){                                // Method to display all elements in the list
        Node tagaPrint = ulo;                           // Create a pointer starting at the head (tagaPrint = "printer" in Filipino)
        while(tagaPrint.susunod != null){               // Loop through all nodes except the last one
            System.out.print(tagaPrint.laman + " ");   // Print the current node's data followed by a space
            tagaPrint = tagaPrint.susunod;              // Move the pointer to the next node
        }
        System.out.print(tagaPrint.laman);             // Print the last node's data without a trailing space
    }

    public void deleteAt(int address){                 // Method to delete a node at a specific position
        if (address == 0){                             // Check if we want to delete the first node (head)
            ulo = ulo.susunod;                         // Move head pointer to the second node (removing first node from list)
        } else{                                        // If we want to delete a node that's not the first
            Node n = ulo;                              // Create a temporary pointer starting at the head
            Node kapalit = null;                       // Declare a replacement pointer (kapalit = "replacement" in Filipino)
            for (int i = 0; i < address - 1; i++){    // Loop to reach the node just before the one to be deleted
                n = n.susunod;                         // Move to the next node (traversing the list)
            }
            kapalit = n.susunod;                       // Point kapalit to the node that will be deleted
            n.susunod = kapalit.susunod;               // Skip over the node to be deleted by linking to the node after it
        }
    }
}                                                       // End of LinkedList class definition
