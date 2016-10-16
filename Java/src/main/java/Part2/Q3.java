package Part2;

/**
 * Created by matao on 10/16/16.
 *
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 *
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a- >b- >d->e
 *
 * 删除单向链表中某个结点，假定你只能访问该结点
 */
public class Q3 {

    /**
     * 将后继结点的值复制给该节点，然后删除后继结点。
     * 若是尾结点，则无解
     */
    public boolean deleteNode(LinkedListNode<Integer> node) {
        if (node == null || node.next == null) {
            return false;
        }

        LinkedListNode<Integer> nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        return true;
    }
}
