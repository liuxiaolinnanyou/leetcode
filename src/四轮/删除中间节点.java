package 四轮;

import java.util.List;

/**
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 */
public class 删除中间节点 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(node);
        deleteNode(node1);
        System.out.println(node);
    }

    // 将下一个结点的值赋给当前节点，当前节点的下一个结点为下下一个结点。
    // 表面删除当前节点，实际删除下一个结点。
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}