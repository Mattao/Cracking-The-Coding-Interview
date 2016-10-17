package Part2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by matao on 10/18/16.
 *
 * Implement a function to check if a linked list is a palindrome
 * 实现一个方法检查一个链表是否回文
 */
public class Q7 {

    /**
     * 快慢指针，fast到末尾时候slow到达中间
     */
    public boolean isPalindrome(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;

        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;   // 跳过奇数个元素时的中间项
        }

        while (slow != null) {
            if (stack.pop().intValue() != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    @Test
    public void testIsPalindrome() {
        // 0->1->2->3->2->1->0
        LinkedListNode<Integer> node0a = new LinkedListNode<Integer>(0, null, null);
        LinkedListNode<Integer> node1a = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> node2a = new LinkedListNode<Integer>(2, null, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3, null, null);
        LinkedListNode<Integer> node0b = new LinkedListNode<Integer>(0, null, null);
        LinkedListNode<Integer> node1b = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> node2b = new LinkedListNode<Integer>(2, null, null);

        node0a.setNext(node1a);
        node1a.setNext(node2a);
        node2a.setNext(node3);
        node3.setNext(node2b);
        node2b.setNext(node1b);
        node1b.setNext(node0b);

        Assert.assertEquals(true, isPalindrome(node0a));
    }
}
