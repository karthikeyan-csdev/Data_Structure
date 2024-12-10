public class App {
    public static void main(String[] args) throws Exception {

        SinglyLinkedList list = new SinglyLinkedList();

        list.addAtBeginning(1);
        list.addAtBeginning(2);
        list.addAtBeginning(3);
        list.addAtEnd(4);
        list.display();
        list.reverseList();
        list.detectLoop();
        System.out.println(list.display());
    }
}
