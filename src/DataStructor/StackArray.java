package DataStructor;

import java.util.EmptyStackException;

public class StackArray{
    private int[] array;
    private int top;
    private final static int size = 100;
    public StackArray(){
        array = new int[size];
        top = -1;
    }

    public void push(int element){
        if(top == size -1)
            throw new StackOverflowError();
        array[++top] = element;
    }

    public int pop(){
        if(top < 0)
            throw new EmptyStackException();
        return array[top--];
    }

    public int peek(){
        if(top < 0)
            throw new EmptyStackException();
        return array[top];
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public static void main(String[] args) {
        StackArray sa = new StackArray();
        sa.push(15);
        sa.push(3);
        sa.push(2);
        System.out.println(sa.peek() + " ");
        while(!sa.isEmpty()){
            System.out.println(sa.pop() + " ");
        }
    }
}
