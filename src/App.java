public class App {
    public static void main(String[] args) throws Exception {

        MyLinkedList ll = new MyLinkedList();
        ll.addAtBeginning(3);
        ll.addAtEnd(4);
        ll.addAtBeginning(2);
        ll.display();
        ll.addAtPosition(0, 2);
        ll.display();
        ll.removeAtPosition(4);
        ll.display();
//        ll.removeFirst();
//      ll.display();
    }
}
