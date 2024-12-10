public class SinglyLinkedList {

    private Node head;
    private int size=0;
    // Definition of Singly linked list node
    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    // Adding Element at End
    public synchronized void addAtEnd(int data) {
        // Create a new node and assign data to it
        Node newNode = new Node(data);
        
        // If the list is empty, the new node becomes the head
        if (this.size==0) {
            this.head = newNode;
            size++;
            System.out.println("Element Added at End: "+data);
            return;
        }
        // Traverse to the last node
        Node n = this.head;
        while (n.next != null) {
            n = n.next;  // Move to the next node
        }
        // Set the next of the last node to the new node
        n.next = newNode;
        size++;
        System.out.println("Element Added at End: "+data);
    }
    
    // Adding Element at Beginning
    public synchronized void addAtBeginning(int data) {
        // Create a new node and assign data to it
        Node newNode = new Node(data);
        
        // If the list is empty, the new node becomes the head
        if (this.size == 0) {
            newNode.next = null;  // This step is actually optional since it's the default value
            this.head = newNode;
            size++;
            System.out.println("Element Added at Beginning: "+data);
            return;
        }
        
        // If the list is not empty, insert the new node at the beginning
        newNode.next = this.head;  // Point the new node to the current head
        this.head = newNode;       // Update the head to be the new node
        size++;
        System.out.println("Element Added at Beginning: "+data);
    }
    
    // Adding Element at Specific Position
    public synchronized void addAtPosition(int data, int position) throws Exception{
        if(position<1 || position > size+1){
            throw new Exception("Position Invalid");
        }
        if(position==1){
            addAtBeginning(data);
            return;
        }
        else if(position==size+1){
            addAtEnd(data);
            return;
        }
        // Create a new node and assign data to it
        Node newNode = new Node(data);

        Node n = this.head;
        for(int i=1;i<position-1;i++){
            n=n.next;
        }
        newNode.next = n.next;
        n.next = newNode;
        size++;
        System.out.println("Element Added: "+data+" at Position: "+position);
    }

    // Searching for an Element (Linear Searching)
    public String search(int data){
        if(this.size==0)
            return "Linked List is Empty";
    
        int position =1;
        Node n = this.head;
        while(n!=null){
            if(n.data==data)
                return "Element Found at Position = "+position;
            n=n.next;
            position++;
        }
        return "Element not Found";
    }

    // Deleting first Node
    public synchronized void removeFirst() throws Exception{
        if(this.size==0)
            throw new Exception("Linked List is Empty!");

        this.head = head.next;
        size--;
        System.out.println("First element deleted");
    }

    // Deleting element
    public synchronized void removeElement(int data) throws Exception{
        if(this.size==0)
            throw new Exception("Linked List is Empty!");
        if(this.head.data==data){
            removeFirst();
            return;
        }
        Node n=this.head;
        while (n.next!=null) {
            if(n.next.data==data){
                n.next=n.next.next;
                size--;
                System.out.println("Element Deleted");
                return;
            }
            n=n.next;
        }
        System.out.println("Element not Found!");
    }

    // Deleting Last Node
    public synchronized void removeLast() throws Exception{
        if (this.size==0) 
            throw new Exception("Linked List is Empty!");
        if (this.size == 1) { // If there's only one element
            this.head = null;
        } else {
            Node n = this.head;
            while (n.next.next != null) { // Traverse to the second-to-last node
                n = n.next;
            }
            n.next = null; // Remove the last node
        }
        size--;
        System.out.println("Last element deleted");
    }

    // Detecting loop
    public void detectLoop(){
        if (this.size==0) 
            System.out.println("Linked List is Empty!");
        if (this.size == 1){ // If there's only one element
            System.out.println("Loop Not Exists");
            return;
        }
        Node slow=this.head;
        Node fast=this.head.next;

        while(fast!=null){
            if(fast==slow){
                System.out.println("Loop Exists");
                return;
            }
            slow = slow.next;
            if(fast.next!=null && fast.next.next!=null)
                fast = fast.next.next;
            else
                break;
        }
        System.out.println("Loop Not Exists");
    }

    //Reversing the List
    public synchronized void reverseList() throws Exception{
        if (this.size == 0)
            throw new Exception("Linked List is Empty!");
        
        Node previous = null;
        Node current = this.head;
        Node next = null;
        while (current!=null) {
            next=current.next;
            current.next = previous;
            previous = current;
            current=next;
        }
        this.head=previous;
        System.out.println("Linked List Reversed!");
    }

    // Merge Two Lists
    public SinglyLinkedList mergeLists(SinglyLinkedList list1) {
        SinglyLinkedList newList = new SinglyLinkedList();
        if (this.size == 0) { 
            return list1; // If the current list is empty, return the passed list.
        }
        if (list1.size == 0) { 
            return this; // If the passed list is null or empty, return the current list.
        }
    
        Node list = this.head;
        while (list != null) { 
            newList.addAtEnd(list.data);
            list = list.next; // Traverse to the end of the current list.
        }
        list = list1.head;
        while (list != null) { 
            newList.addAtEnd(list.data);
            list = list.next; // Traverse to the end of the current list.
        }
        newList.size = this.size+list1.size;
        return newList; // Return the merged list (current list).
    }
    
    // Display the Linked list
    public String display(){
        if(this.size==0){
            System.out.println("LinkedList is Empty!");
            return "";
        }
        StringBuilder list = new StringBuilder();
        // System.out.println("Linked List : ");
        Node n = this.head;
        while(n!=null){
            list.append(n.data+" -> ");
            n=n.next;
        }
        list.append("null");
        return list.toString();
    }

    public int getSize(){
        return this.size;
    }
    public synchronized void clear() {
        this.head = null;
        System.out.println("Linked List cleared");
    }
    
}
