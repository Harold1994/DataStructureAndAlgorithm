package DataStructor;

import com.sun.glass.ui.Size;
import com.sun.glass.ui.View;

import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T [] theItems;

    public MyArrayList(){
        clear();
    }

    public void clear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return theSize == 0;
    }

    public void trimToSize(){
        ensureCapacity(size());
    }

    public T get(int idx){
        if(idx < 0 || idx >size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public T set(int idx, T newVal){
        if(idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    private void ensureCapacity(int newCapacity) {
        if(newCapacity < theSize)
            return;

        T [] old = theItems;
        theItems = (T [])new Object[newCapacity];
        for(int i = 0; i < size(); i++)
            theItems[i] = old[i];
    }

    public boolean add(T x){
        add(size(),x);
        return true;
    }

    public boolean add(int idx, T x) {
        if(theItems.length == theSize)
            ensureCapacity(2*size() + 1);
        for(int i = theSize; i > idx; i--){
            theItems[i] = theItems[i-1];
        }
        theItems[idx] = x;
        theSize++;
        return true;
    }

    public T remove(int idx){
        T removedItem = theItems[idx];
        if(idx <0 || idx > size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        for( int i = idx; i<size()-1; i++)
            theItems[i] = theItems[i+1];
        theSize--;
        return removedItem;
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> ma = new MyArrayList<>();
        ma.add(15);
        ma.add(88);
        ma.add(2);
        ma.set(3,1);
        Iterator a = ma.iterator();
        while(a.hasNext())
            System.out.println(a.next() + " ");
    }
}
