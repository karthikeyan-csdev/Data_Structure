public class App {
    public static void main(String[] args) throws Exception {

        MyArray array = new MyArray(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.addAtPosition(0, 2);
        array.display();
    }
}
