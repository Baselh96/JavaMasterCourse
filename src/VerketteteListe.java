import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class VerketteteListe implements Iterable{


    private class Node{
        private Object data;
        private Node next;
        public Node(Object obj, Node next){
            this.data = obj;
            this.next = next;
        }
    }

    private Node first = null;
    private int index = 0;


    public void addfirst( Object obj){
        first = new Node(obj, first);
        index++;
    }
    public void add( int position, Object obj){
        Node temp = first;
        int newindex = 0;
        while ( temp != null){
            if(newindex == position-1){
                temp.next = new Node(obj, temp.next);
                index++;
                break;
            }
            temp = temp.next;
            newindex++;
        }
    }
    public void addLast( Object newobj){
        Node temp = first;
        int newindex = 0;
        while ( temp != null){
           if( newindex == index-1){
                temp.next = new Node( newobj, temp.next);
                index++;
                break;
            }
            temp = temp.next;
            newindex++;
        }
    }
    public void print(){
        Node temp = first;
        if(first == null) return;
        int newindex = 0;
        while (newindex < index ){
            System.out.println(temp.data);
            newindex++;
            temp = temp.next;
        }
    }
    public int size(){
        return index;
    }
    public boolean isEmpty(){
        return index == 0;
    }
    public boolean contains(Object obj){
        Node temp = first;
        while ( temp != null){
            if(temp.data == obj ) return true;
            temp = temp.next;
        }
        return false;
    }
    public void clear(){
        first = null;
        index = 0;
    }
    public Object get(int position){
        Node temp = first;
        int newindex = 0;
        while ( temp != null){
            if(newindex == position) return temp.data;
            temp = temp.next;
            newindex++;
        }
        throw new IndexOutOfBoundsException("Sie greifen außerhalb der Listengrenze!");
    }
    public void set(int position, Object newobj){
        Node temp = first;
        int newindex = 0;
        while ( temp != null){
            if(newindex == position) {
                temp.data = newobj;
                break;
            }
            temp = temp.next;
            newindex++;
        }
    }
    public int indexOf(Object obj){
        Node temp = first;
        int newindex = 0;
        while ( temp != null){
            if(temp.data == obj) {
                return newindex;
            }
            temp = temp.next;
            newindex++;
        }
        return -1;
    }
    public void remove( Object obj){
        Node temp = first;
        while ( temp != null){
            if(temp.data == obj) {
                temp.data = temp.next.data ;
                temp.next = temp.next.next;
                index--;
                break;
            }
            temp = temp.next;
        }
    }
    public void remove( int position){
        Node temp = first;
        int newindex = 0;
        while ( temp != null){
            if(newindex == position) {
                temp.data = temp.next.data ;
                temp.next = temp.next.next;
                index--;
                break;
            }
            temp = temp.next;
            newindex++;
        }
    }

    public Object[] toArray( ){
        Node temp = first;
        Object[] array = new Object[index];
        int newindex = 0;
        while ( newindex < index){
            array[newindex] = temp.data;
            newindex++;
            temp = temp.next;
        }
        return array;
    }
    @Override
    public Iterator iterator() {
        return new ElementIterator();
    }
    public class ElementIterator implements Iterator<Object>{
        Node run = first;
        @Override
        public boolean hasNext() {
            return run != null;
        }

        @Override
        public Object next() {
            if (hasNext()){
                Object temp = run.data;
                run = run.next;
                return temp;
            }
            throw new NoSuchElementException() ;
        }
    }
}
