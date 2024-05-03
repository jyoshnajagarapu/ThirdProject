package DataStructuresPack;

class SingleLinkedList {
    Node head;

    /* Linked list Node. This inner class is made static so that
    main() can access it */
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public void printList()
    {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    //Add a node at the front: (4 steps process)
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    //Add after given  node
    public void insertAfter(Node prev_node, int new_data)
    {
        if (prev_node == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }
   //at the end
    public void append(int new_data)
    {
        Node new_node = new Node(new_data);
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;
        return;
    }

    void deleteNode(int key)
    {
        Node temp = head, prev = null;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return;
        prev.next = temp.next;
    }


    public static void main(String[] args)
    {
        //LinkedList llist = new LinkedList();
//        llist.head = new Node(1);
//        Node second = new Node(2);
//        Node third = new Node(3);
//        llist.head.next = second;
//        second.next = third;
//        llist.printList();
//        System.out.println("Add a node at the front");
//        llist.push(4);
//        llist.printList();

        SingleLinkedList llist = new SingleLinkedList();
            llist.append(6);
            llist.push(7);
            llist.push(1);
            llist.append(4);
            llist.insertAfter(llist.head.next, 8);
            System.out.println("\nCreated Linked list is: ");
            llist.printList();
            llist.deleteNode(8);
            System.out.println("after deleting 8 node ");
            llist.printList();


    }
    //17864
}


 class DLL {
    Node head;
    class Node {
        int data;
        Node prev;
        Node next;
        Node(int d) {
            data = d;
        }
    }
     // Adding a node at the front of the list
     public void push(int new_data)
     {
         Node new_Node = new Node(new_data);
         new_Node.next = head;
         new_Node.prev = null;
         if (head != null)
             head.prev = new_Node;
         head = new_Node;
     }
     /* Given a node as prev_node, insert
    a new node after the given node */
     public void InsertAfter(Node prev_Node, int new_data)
     {
         if (prev_Node == null) {
             System.out.println("The given previous node cannot be NULL ");
             return;
         }
         Node new_node = new Node(new_data);
         new_node.next = prev_Node.next;
         prev_Node.next = new_node;
         new_node.prev = prev_Node;
         if (new_node.next != null)
             new_node.next.prev = new_node;
     }
     // Add a node at the end of the list
     void append(int new_data)
     {
         Node new_node = new Node(new_data);
         Node last = head;
         new_node.next = null;
         if (head == null) {
             new_node.prev = null;
             head = new_node;
             return;
         }
         while (last.next != null)
             last = last.next;
         last.next = new_node;
         new_node.prev = last;
     }
     // Add a node before the given node
     public void InsertBefore(Node next_node, int new_data)
     {
         if(next_node == null)
         {
             System.out.println("The given next node can not be NULL");
             return;
         }
         Node new_node = new Node(new_data);
         new_node.prev = next_node.prev;
         next_node.prev = new_node;
         new_node.next = next_node;
         if(new_node.prev != null)
             new_node.prev.next = new_node;
         else
             head = new_node;
     }
     // This function prints contents of
     // linked list starting from the given node
     public void printlist(Node node)
     {
         Node last = null;
         System.out.println("Traversal in forward Direction");
         while (node != null) {
             System.out.print(node.data + " ");
             last = node;
             node = node.next;
         }
         System.out.println();
         System.out.println("Traversal in reverse direction");
         while (last != null) {
             System.out.print(last.data + " ");
             last = last.prev;
         }
     }

     void deleteNode(Node del)
     {
         if (head == null || del == null) {
             return;
         }
         if (head == del) {
             head = del.next;
         }
         if (del.next != null) {
             del.next.prev = del.prev;
         }
         if (del.prev != null) {
             del.prev.next = del.next;
         }
         return;
     }

     public static void main(String[] args)
     {
         DLL dll = new DLL();
         dll.append(6);
         dll.push(7);
         dll.push(1);
         dll.append(4);
         dll.InsertAfter(dll.head.next, 8);
         dll.InsertBefore(dll.head.next.next, 5);
         System.out.println("Created DataStructuresPack.DLL is: ");
         dll.printlist(dll.head);
//175864
         // Deleting first node
         dll.deleteNode(dll.head);
         dll.printlist(dll.head);

         dll.deleteNode(dll.head.next);
         dll.printlist(dll.head);
     }
}
