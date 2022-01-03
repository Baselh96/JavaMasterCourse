package Baumstruktur;

public class Tree<T> implements TreeNode<T>{
    protected TreeNode left, right;
    protected T data;

    public Tree(T data, TreeNode left, TreeNode right) {
        if(left == null || right == null) throw new RuntimeException("Biite nutzen Sie die TreeNode.EMPTY");
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Tree(T data){
        this(data, EMPTY, EMPTY);
    }

    @Override
    public boolean isEmply() {
        return false;
    }

    @Override
    public int size() {
        return 1+ left.size() + right.size();
    }

    @Override
    public void process(){
        System.out.print(" "+data);
    }
    @Override
    public void addSorted(T data){
        if(data.toString().compareTo(this.data.toString()) < 0){
            if(left == EMPTY){
                left = new Tree(data);
            }else{
                left.addSorted(data);
            }
        }else{
            if(right == EMPTY){
                right = new Tree(data);
            }else{
                right.addSorted(data);
            }
        }
    }
    @Override
    public boolean contain(T data){
        if(this.data == data){
            return true;
        }else{
            if( data.toString().compareTo(this.data.toString()) < 0){
                if(left.isEmply()){
                    return false;
                }else{
                    return left.contain(data);
                }
            }else{
                if(right.isEmply()){
                    return false;
                }else {
                    return right.contain(data);
                }
            }
        }
    }

    @Override
    public int compareTo(int data) {
        if( (int)this.data > data){
            return 1;
        }else if( (int)this.data == data){
            return 0;
        }
        return -1;
    }

    @Override
    public void processAllPreOrder() {
        process();
        left.processAllPreOrder();
        right.processAllPreOrder();
    }
    @Override
    public void processAllInOrder() {
        left.processAllInOrder();
        process();
        right.processAllInOrder();
    }

    @Override
    public void processAllPostOrder() {
        left.processAllPostOrder();
        right.processAllPostOrder();
        process();
    }
}
