package Baumstruktur;

public class EmptyTree<T> implements TreeNode<T>{
    @Override
    public boolean isEmply() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void process() {

    }

    @Override
    public void processAllPreOrder() {

    }

    @Override
    public void processAllInOrder() {

    }

    @Override
    public void processAllPostOrder() {

    }
    @Override
    public void addSorted(T data) {
    }
    @Override
    public boolean contain(T data) {
        return false;
    }

    @Override
    public int compareTo(int data) {
        return -1;
    }

}
