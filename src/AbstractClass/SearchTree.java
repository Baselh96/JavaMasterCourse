package AbstractClass;

public class SearchTree implements NodeList{
    private ListItem root = null;
    public SearchTree(ListItem root) {
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
                    current.setNext(item);
                    return true;
                }else{
                    current = current.next();
                }
            }else if(current.compareTo(item) > 0){
                if(current.previous() == null){
                    current.setPrevious(item);
                    return true;
                }else{
                    current = current.previous();
                }
            }else{
                return false;
            }
        }
        return false;
    }
    @Override
    public boolean removeItem(ListItem item) {
        ListItem current = this.root;
        ListItem parentItem = current;
        while (current != null){
            if(current.compareTo(item) < 0){
                parentItem = current;
                current = current.next();
            }else if(current.compareTo(item) == 0){
                performRemoval(current, parentItem );
                return true;
            }else{
                parentItem = current;
                current = current.previous();
            }
        }
        return false;
    }
    @Override
    public void traverse(ListItem root) {
        if(root != null){
           traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
    private void performRemoval(ListItem item, ListItem parent){
        if(item.next() == null){
            if(parent.next() == item){
                parent.setNext(item.previous());
            }else if(parent.previous() == item){
                parent.setPrevious(item.previous());
            }else{
                this.root = item.previous();
            }
        }else if(item.previous() == null){
            if(parent.next() == item){
                parent.setNext(item.next());
            }else if(parent.previous() == item){
                parent.setPrevious(item.next());
            }else{
                this.root = item.next();
            }
        }else{
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null){
                leftmostParent = current;
                current = current.previous();
            }
            item.setValue(current.getValue());
            if(leftmostParent == item){
                item.setNext(current.next());
            }else{
                leftmostParent.setPrevious(current.next());
            }
        }
    }
}
