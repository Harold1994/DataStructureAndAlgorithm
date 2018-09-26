package DataStructor;

public class SingleLinkedList<T> {
    private int size;
    private int modcount = 0;
    private Node<T> head;
    private Node<T> rear;
    private Node<T> point;
    private static class Node <T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public SingleLinkedList() {
        clear();
    }

    private void clear() {
        head = new Node<T>(null, null);
        rear = head;
        size = 0;
    }

    public void add(T elem) {
        point = new Node<T>(elem, null);
        rear.next = point;
        rear = point;
        size ++;
    }

    public void traverse() {
        point = head;
        if (head != null) {
            System.out.println("[" + head.data + "]");
        }
        while (point.next != null) {
            System.out.println("->[" + point.next.data + "]");
            point = point.next;
        }
        System.out.println();
    }
    
    public T find(int position) {
        if (position >= 0 && position <size) {
            Node<T> tmp = movePosistion(position);
            return (T) tmp.next.data;
        }
        return null;
    }

    private Node<T> movePosistion(int position) {
        if (position < 0)
            return head;
        if (position > size)
            return rear;

        if (position >=0 && position< size) {
            point = head;
            while (point != null) {
                if (position == 0)
                    break;
                position--;
                point = point.next;
            }
        }
        return point;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.add(5);
        list.add(12);
        list.add(112);
        list.traverse();
    }
}
