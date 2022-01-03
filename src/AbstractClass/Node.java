package AbstractClass;

public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    public ListItem next() {
        return rightLink;
    }

    @Override
    public ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink ;
    }

    @Override
    public ListItem previous() {
        return leftLink;
    }

    @Override
    public ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return leftLink;
    }

    @Override
    public int compareTo(ListItem item) {
        if(item != null){
            return this.getValue().toString().compareTo(item.getValue().toString());
        }
        return -1;
    }
}
