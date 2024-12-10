public class DoublyLinkedList {
    
    private int size;
    private class Node{
        int data;
        Node previous;
        Node next;

        Node(int data){
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    private Node head;

    DoublyLinkedList(){
        this.head=null;
        this.size=0;
    }

    // Get size of the list
    public int getSize() {
        return size;
    }

    public synchronized void clear() {
        this.head = null;
        System.out.println("Linked List cleared");
    }
    
    // Add element at beginning

    public synchronized void addAtBeginning(int data){
        Node newNode = new Node(data);

        if(this.head==null){
            this.head = newNode;
        }
        else{
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        size++;
        System.out.println("Element Added at Beginning: "+data);
    }

    //Adding Element at End
    public synchronized void addAtEnd(int data){
        Node newNode = new Node(data);

        if(this.head==null){
            this.head = newNode;
            System.out.println("Element Added at End: "+data);
            size++;
            return;
        }
        Node n = this.head;
        while (n.next!=null) {
            n=n.next;
        }
        newNode.previous = n;
        n.next =  newNode;
        size++;
        System.out.println("Element Added at End: "+data);
    }

    // Deleting first Node
    public  synchronized void removeFirst(){
        if(this.size==0){
            System.out.println("Linked List is Empty!");
            return;
        }
        if (this.size==1) {
            System.out.println("First element deleted");
            this.head = null;
            size--;
            return;
        }
        this.head = this.head.next;
        this.head.previous = null;
        System.out.println("First element deleted");
    }

    // Deleting Last node
    public synchronized void removeLast(){
        if(this.size==0){
            System.out.println("Linked List is Empty!");
            return;
        }
        if (this.size==1) {
            System.out.println("Last element deleted");
            this.head = null;
            size--;
            return;
        }
        Node current = this.head;
        while (current.next.next!=null) {
            current = current.next;
        }
        current.next = null;
        size--;
        System.out.println("Last element deleted");
    }

     // Search for a value in the list
     public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Display the Linked list
    public synchronized String display(){
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
}
