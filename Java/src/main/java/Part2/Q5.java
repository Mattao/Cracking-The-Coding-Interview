package Part2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by matao on 10/17/16.
 *
 * You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in reverse order, such that the Ts digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
 * Output: 2 -> 1 -> 9.That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
 * Input:(6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
 * Output: 9 -> 1 -> 2.That is, 912.
 *
 * 给定两个链表表示的证书，每个结点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对两个整数求和，并用链表形式返回结果
 *
 */
public class Q5 {

    /**
     * @param carry 进位
     * @return
     */
    public LinkedListNode<Integer> addLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2,
                                            int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode<Integer> result = new LinkedListNode<Integer>(0, null, null);

        int value = carry;
        if (l1 != null) {
            value += l1.data;
            l1 = l1.next;
        }
        if (l2 != null) {
            value += l2.data;
            l2 = l2.next;
        }

        result.data = value % 10;   // 取其个位
        carry = value / 10;         // 取其进位

        LinkedListNode nextNode = addLists(l1, l2, carry);

        result.setNext(nextNode);
        return result;
    }

    @Test
    public void testAddLists() {
        //Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295.
        //Output: 2 -> 1 -> 9.That is, 912.
        LinkedListNode<Integer> node7 = new LinkedListNode<Integer>(7, null, null);
        LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(1, null, null);
        LinkedListNode<Integer> node6 = new LinkedListNode<Integer>(6, null, null);
        node7.setNext(node1);
        node1.setNext(node6);

        LinkedListNode<Integer> node5 = new LinkedListNode<Integer>(5, null, null);
        LinkedListNode<Integer> node9 = new LinkedListNode<Integer>(9, null, null);
        LinkedListNode<Integer> node2 = new LinkedListNode<Integer>(2, null, null);
        node5.setNext(node9);
        node9.setNext(node2);

        LinkedListNode<Integer> result = addLists(node7, node5, 0);
        Assert.assertEquals("2->1->9", result.printForward());

        //Input:(8->3) + (4).That is 38 + 4.
        //Output: 2->4, that is 42;
        LinkedListNode<Integer> node8 = new LinkedListNode<Integer>(8, null, null);
        LinkedListNode<Integer> node3 = new LinkedListNode<Integer>(3, null, null);
        node8.setNext(node3);
        LinkedListNode<Integer> node4 = new LinkedListNode<Integer>(4, null, null);

        result = addLists(node8, node4, 0);
        Assert.assertEquals("2->4", result.printForward());
    }
}
