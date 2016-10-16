package Part2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by matao on 10/16/16.
 *
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * 移除无序列表中重复的节点。
 * 如果不得使用临时缓冲区，又改如何解决？
 */
public class Q1 {

    public void deleteDups(LinkedListNode<Integer> n) {
        // 单向链表
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode<Integer> pre = null;
        while (n != null) {
            if (set.contains(n.data)) {
                pre.next = n.next;
            } else {
                set.add(n.data);
                pre = n;
            }
            n = n.next;
        }
    }

    // 双指针
    public void deleteDupsAdvanced(LinkedListNode<Integer> head) {
        if (head == null) {
            return;
        }
        LinkedListNode<Integer> current = head;
        while (current != null) {
            LinkedListNode<Integer> runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    @Test
    public void testDeleteDups() {
        // 1->2->2->4   =>  1->2->4
        LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2, null, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(2, null, null);
        LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4, null, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        deleteDups(node1);
        Assert.assertEquals("1->2->4", node1.printForward());
    }

    @Test
    public void testDeleteDupsAdcanced() {
        // 1->2->2->4   =>  1->2->4
        LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2, null, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(2, null, null);
        LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4, null, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        deleteDupsAdvanced(node1);
        Assert.assertEquals("1->2->4", node1.printForward());
    }

}
