package DataStructor;

import com.sun.glass.ui.Size;
import org.omg.CORBA.MARSHAL;

import java.util.NoSuchElementException;

public class MyQueue<T> implements Queue<T>{
    private static final int DEFAULT_SIZE = 10;
    private T [] elementData;
    private int front,rear;
    private int size = 0;

    public MyQueue() {
        elementData = (T[]) new Object[DEFAULT_SIZE];
        front = rear = 0;
    }

    public MyQueue(int capacity){
        elementData = (T[]) new Object[capacity];
        front = rear = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean add(T element) {
        if(front == (rear + 1)%this.elementData.length){
            ensureCapacity(elementData.length * 2);
        }
        elementData[rear] = element;
        rear = (rear + 1) % elementData.length;
        size++;
        return true;
    }

    private void ensureCapacity(int cap) {
        if (cap <size)
            return;
        T [] old = elementData;
        elementData = (T[]) new Object[cap];
        int j = 0;
        for(int i = this.front; i<this.rear; i++)
            elementData[j++] = old[i];
        this.front = 0;
        this.rear = j;
    }

    @Override
    public boolean offer(T data) {
        if(data == null)
            throw new NullPointerException("the data can't be null");
        if(front == (rear + 1)%this.elementData.length){
            throw new IllegalArgumentException("The capacity of SeqQueue has reached its maximum");
        }
        elementData[rear] = data;
        rear = (rear + 1) % elementData.length;
        size++;
        return true;
    }

    @Override
    public T peek() {
        if(this.isEmpty())
            return null;
        return elementData[front];
    }

    @Override
    public T element() {
        if(isEmpty()){
            throw new NoSuchElementException("The SeqQueue is empty");
        }
        return peek();
    }

    @Override
    public T poll() {
        T temp = this.elementData[front];
        front = (front + 1)%this.elementData.length;
        size--;
        return temp;
    }

    @Override
    public T remove() {
        if (isEmpty()){
            throw new NoSuchElementException("The SeqQueue is empty");
        }
        return poll();
    }

    @Override
    public void clearQueue() {
        for(int i = this.front; i!=this.rear; i=(i+1)%this.elementData.length){
            elementData[i] = null;
        }
        this.front = this.rear;
        size = 0;
    }

    public static void main(String[] args) {
        MyQueue<Integer> q= new MyQueue<Integer>();
        q.add(15);
        q.add(48);
        q.offer(18);
        System.out.println(q.size);
        while(!q.isEmpty()){
            System.out.println(q.poll() + " ");
        }
    }
}
