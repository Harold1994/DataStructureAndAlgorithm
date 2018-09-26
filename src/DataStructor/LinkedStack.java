package DataStructor;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {
    private class Node<U>{
        private Node<U> next;
        private U item;

        Node(){
            this.item = null;
            this.next = null;
        }

        public Node(Node<U> next, U item) {
            this.next = next;
            this.item = item;
        }

        boolean end(){
            return next==null && item == null;
        }
    }

    private Node<T> top;

    public LinkedStack() {
        this.top = new Node<T>();
    }

    @Override
    public T pop() {
        if(this.isEmpty())
            throw new EmptyStackException();
        T result = top.item;
        if(!top.end())
            top = top.next;
        return result;
    }

    @Override
    public T peek() {
        if(this.isEmpty())
            throw new EmptyStackException();
        T result = top.item;
        return result;

    }

    @Override
    public void push(T element) {
        top = new Node<T>(top,element);
    }

    @Override
    public boolean isEmpty() {
        return top.end();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> sa = new LinkedStack<Integer>();
        sa.push(15);
        sa.push(3);
        sa.push(2);
        System.out.println(sa.peek() + " ");
        while(!sa.isEmpty()){
            System.out.println(sa.pop() + " ");
        }
    }
}
