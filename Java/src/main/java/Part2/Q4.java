package Part2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/17/16.
 * <p>
 * Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * <p>
 * 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 */
public class Q4 {

    /**
     * 创建两个链表，一个存放小于x的元素，一个存放大于等于x的元素，最后再合并
     */
    public LinkedListNode<Integer> partition(LinkedListNode<Integer> node, int x) {
        LinkedListNode<Integer> beforeStart = null;
        LinkedListNode<Integer> beforeEnd = null;
        LinkedListNode<Integer> afterStart = null;
        LinkedListNode<Integer> afterEnd = null;

        while (node != null) {
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = afterEnd.next;
                }
            }
            node = node.next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    @Test
    public void testPartition() {
        // 1->3->7->5->2->9
        LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(3, null, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(7, null, null);
        LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(5, null, null);
        LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(2, null, null);
        LinkedListNode<Integer> node6 = new LinkedListNode<Integer>(9, null, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        LinkedListNode<Integer> h = partition(node1, 5);

        Assert.assertEquals("1->3->2->7->5->9", h.printForward());
    }
}
