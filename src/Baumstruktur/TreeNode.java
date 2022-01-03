package Baumstruktur;

public interface TreeNode<T> {
    final EmptyTree EMPTY = new EmptyTree();
    boolean isEmply();
    int size();
    // die Knoten verarbeiten
    void process();
    // Alle Knoten in Pre-Order-Reihenfolge durchlaufen.
    void processAllPreOrder();

    // Alle Knoten in In-Order-Reihenfolge durchlaufen.
    void processAllInOrder();

    // Alle Knoten in Post-Order-Reihenfolge durchlaufen.
    void processAllPostOrder();
    // Fügt einen Wert sortiert in den Baum ein.
    void addSorted(T data);
    // überprüft, ob ein bestimmtes Element im Baum gibt.
    boolean contain(T data);
    int compareTo(int data);
}
