package DataStructor;

public interface Queue<T> {
    int size();
    boolean isEmpty();
    /**
     * data 入队,添加成功返回true,否则返回false,可扩容
     * @param data
     * @return
     */
    boolean add(T element);

    /**
     * offer可插入一个元素,该方法只能通过抛出未经检查的异常使添加元素失败
     * @param data
     * @return
     */
    boolean offer(T data);
    T peek();// 返回队头元素,不执行删除操作,若队列为空,返回null
    T element();//返回队头元素,不执行删除操作,若队列为空,抛出异常:NoSuchElementException
    T poll();//出队
    T remove();
    void clearQueue();
}
