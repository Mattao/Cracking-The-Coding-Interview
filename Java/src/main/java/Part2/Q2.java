package Part2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/16/16.
 *
 * Implement an algorithm to find the kth to last element of a singly linked list.
 *
 * 找出单向链表倒数第K个节点
 */
public class Q2 {

    public LinkedListNode<Integer> lastKth(LinkedListNode<Integer> head, int k) {
        if (k <= 0) {
            return null;
        }

        LinkedListNode<Integer> p = head;
        LinkedListNode<Integer> q = head;
        while (--k > 0) {
            if (q == null) {    // 错误检查
                return null;
            }
            q = q.next;
        }
        if (q == null) {
            return null;
        }

        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        return p;
    }

    @Test
    public void testLastKth() {
        // 1->2->3->4 返回倒数第2个， 即3
        LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2, null, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3, null, null);
        LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4, null, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Assert.assertEquals(3, lastKth(node1, 2).data.intValue());
    }
}
