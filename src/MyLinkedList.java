public class MyLinkedList<A> {

    private Node head;
    // definition of linked list node
    class Node{
        A data;
        Node next;
    }

    // element inserted at last
    public void add(A data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if(head==null){
            head = newNode;
        }
        else{
            Node n = head;
            while(n.next!=null){
                n=n.next;
            }
            n.next = newNode;
        }
    }



    public void addAtIndex(A data,int index){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if(head==null){
            System.out.println("Linked List is Empty");
        }
        else{
            
        }
    }

    public void display(){
        Node n = head;
        while(n.next!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.print(n.data);
        System.out.println();
    }
}
