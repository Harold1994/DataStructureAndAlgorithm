package DataStructor;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackList<T> implements Stack<T> {
    private List<T> list;

    public StackList() {
        this.list = new ArrayList<T>();
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        return list.remove(list.size()-1);
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return list.get(list.size()-1);
    }

    @Override
    public void push(T element) {
        list.add(element);
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
