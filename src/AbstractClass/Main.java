package AbstractClass;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.addItem(new Node(34));
        list.addItem(new Node(14));
        list.addItem(new Node(44));
        list.addItem(new Node(24));
        list.addItem(new Node(5));
        list.traverse(list.getRoot());
    }
}
