public class MyLinkedList {

    private Node head;
    private int size=0;
    // Definition of Singly linked list node
    class Node{
        int data;
        Node next;
    }

    // Adding Element at End
    public void addAtEnd(int data) {
        // Create a new node and assign data to it
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;  // The new node will be the last, so its next is null
    
        // If the list is empty, the new node becomes the head
        if (head == null) {
            head = newNode;
            size++;
            System.out.println("Element Added at End: "+data);
            return;
        }
        // Traverse to the last node
        Node n = head;
        while (n.next != null) {
            n = n.next;  // Move to the next node
        }
        // Set the next of the last node to the new node
        n.next = newNode;
        size++;
        
        System.out.println("Element Added at End: "+data);
    }
    
    // Adding Element at Beginning
    public void addAtBeginning(int data) {
        // Create a new node and assign data to it
        Node newNode = new Node();
        newNode.data = data;
        
        // If the list is empty, the new node becomes the head
        if (head == null) {
            newNode.next = null;  // This step is actually optional since it's the default value
            head = newNode;
            size++;
            System.out.println("Element Added at Beginning: "+data);
            return;
        }
        
        // If the list is not empty, insert the new node at the beginning
        newNode.next = head;  // Point the new node to the current head
        head = newNode;       // Update the head to be the new node
        size++;

        System.out.println("Element Added at Beginning: "+data);
    }
    
    // Adding Element at Specific Position
    public void addAtPosition(int data, int position) throws Exception{
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
        Node newNode = new Node();
        newNode.data = data;

        Node n = head;
        for(int i=1;i<position-1;i++){
            n=n.next;
        }
        newNode.next = n.next;
        n.next = newNode;
        size++;
        System.out.println("Element Added: "+data+" at Position: "+position);
    }

    // Display the Linked list
    public void display(){
        if(head==null){
            System.out.println("LinkedList is Empty!");
            return;
        }
        System.out.println("Linked List : ");
        Node n = head;
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.println();
    }
}
