package Part2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/18/16.
 *
 * Given a circular linked list,
 * implement an algorithm which returns the node at the beginning of the loop.
 *
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 *
 * EXAMPLE
 * Input:A ->B->C->D->E->C Output:C
 *
 * 给定一个有环链表，实现一个算法返回环路的开头结点
 */
public class Q6 {

    public LinkedListNode<Integer> findBeginning(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // 确保有环路
        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;    // 这时候fast移动到头部，然后每次移动一步，最后会跟slow在环路开头相遇
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    @Test
    public void testFindBeginning() {
        // 1->2->3->4->5->3
        LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2, null, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3, null, null);
        LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4, null, null);
        LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(5, null, null);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node3);

        Assert.assertEquals(3, findBeginning(node1).data.intValue());

    }
}
