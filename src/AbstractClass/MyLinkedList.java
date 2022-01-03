package AbstractClass;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }
    @Override
    public ListItem getRoot() {
        return root;
    }
    @Override
    public boolean addItem( ListItem item) {
        if(this.root == null ){
            this.root = item;
            return true;
        }
        ListItem current = this.root;
        while (current != null){
            if(current.compareTo(item) < 0){
                if(current.next() == null){
                    current.setNext(item).setPrevious(current);
                    return true;
                }else{
                    current = current.next();
                }
            }else if(current.compareTo(item) > 0){
                if(current.previous() == null){
                    root.setPrevious(item).setNext(root);
                    root = item;
                }else{
                    current.previous().setNext(item).setPrevious(current.previous());
                    item.setNext(current).setPrevious(item);
                }
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    @Override
    public boolean removeItem(ListItem item) {
        ListItem current = this.root;
        while (current != null){
            if(current.compareTo(item) < 0){
                current = current.next();
            }else if(current.compareTo(item) == 0){
                if( root == current ){
                    root = root.next();
                }else{
                    current.previous().setNext(current.next());
                    if(current.next() != null){
                        current.next().setPrevious(current.previous());
                    }
                }
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    @Override
    public void traverse(ListItem root) {
        if(root == null){
            System.out.println("The list is empty");
        }else{
            while (root != null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
