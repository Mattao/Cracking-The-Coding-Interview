package Part2;

/**
 * Created by matao on 10/16/16.
 *
 * 双向链表
 */
public class LinkedListNode<T> {
    public LinkedListNode<T> next;
    public LinkedListNode<T> prev;
    public LinkedListNode<T> last;
    public T data;

    public LinkedListNode(T data, LinkedListNode<T> n, LinkedListNode<T> p) {
        this.data = data;
        setNext(n);
        setPrevious(p);
    }

    public void setNext(LinkedListNode<T> n) {
        next = n;
        if (this == last) {
            last = n;
        }
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNode<T> p) {
        prev = p;
        if (p != null && p.next != this) {
            this.setNext(p);
        }
    }

    public String printForward() {
        if (next != null) {
            return data + "->" + next.printForward();
        } else {
            return data + "";
        }
    }

    public LinkedListNode clone() {
        LinkedListNode<T> next2 = null;
        if (next != null) {
            next2 = next.clone();
        }
        LinkedListNode<T> head2 = new LinkedListNode(data, next2, null);
        return head2;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2, null, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3, null, null);

        node1.setNext(node2);
        node2.setPrevious(node1);
        node2.setNext(node3);
        node3.setPrevious(node2);

        LinkedListNode<Integer> p = node1;
        System.out.print(p.printForward());
    }
}
