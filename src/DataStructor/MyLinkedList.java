package DataStructor;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> beginMarker;
    private Node<T> endMarker;
    private int theSize;
    private int modCount = 0;

    private static class Node<T>{

        public T data;
        public Node<T> next,prev;
        public Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList() {
        clear();
    }

    private void clear() {
        beginMarker = new Node<T>(null,null,null);
        endMarker = new Node<T>(null,beginMarker,null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount ++;
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean add(T x){
        add(size(),x);
        return true;
    }

    private void add(int idx, T x) {
        addBefore(getNode(idx),x);
    }

    private void addBefore(Node<T> node, T x) {
        Node<T> newNode = new Node<T>(x,node.prev,node);
        newNode.prev.next = newNode;
        node.prev = newNode;
        theSize++;
        modCount++;
    }

    private Node<T> getNode(int idx) {
        Node<T> p;
        if(idx < 0 || idx >size())
            throw new IndexOutOfBoundsException();
        if(idx < size()/2){
            p = beginMarker.next;
            for(int i = 0; i< idx; i++){
                p = p.next;
            }
        }
        else{
            p = endMarker;
            for(int i = size(); i > idx; i--)
                p = p.prev;
        }
        return p;
    }

    public T get(int idx){
        return getNode(idx).data;
    }

    public T set(int idx, T newVal){
        Node<T> P = getNode(idx);
        T oldVl = P.data;
        P.data = newVal;
        return oldVl;
    }

    public T remove(int idx){
        return remove(getNode(idx));
    }

    private T remove(Node<T> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        theSize--;
        modCount++;
        return  node.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        Node<T> current = beginMarker.next;
        boolean okToRemove = false;
        private int expetedCount = modCount;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if(expetedCount != modCount)
                throw new ConcurrentModificationException();
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if(expetedCount != modCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expetedCount++;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> ml = new MyLinkedList<>();
        ml.add(12);
        ml.add(15);
        ml.add(1,5);
        Iterator a = ml.iterator();
        while(a.hasNext())
            System.out.println(a.next() + " ");
    }
}
