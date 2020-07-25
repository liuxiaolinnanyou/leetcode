package 五轮;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class 反转链表2 {
    public static void main(String[] args) {

    }

    // 双指针 - 头插法
    // 我们首先根据方法的参数m确定g和p的位置。将g移动到第一个要反转的节点的前面，
    // 将p移动到第一个要反转的节点的位置上。我们以m=2，n=4为例。
    // (2)将p后面的元素删除，然后添加到g的后面。也即头插法。
    // 根据m和n重复步骤(2)
    // 返回dummyHead.next
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;
        while (step < m - 1) {
            g = g.next;
            p = p.next;
            step++;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }
}