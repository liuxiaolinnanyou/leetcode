package newcoder_剑指offer;

// 输入一个链表，反转链表后，输出新链表的表头。
public class 反转链表输出新链表表头 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        reverseList(a);
        while (e != null) {
            System.out.println(e.val);
            e = e.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        // 判断链表为空或长度为 1 的情况
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;  // 当前节点的前一个节点
        ListNode next = null; // 当前节点的下一个节点
        while (head != null) {
            next = head.next; // 记录当前节点的下一个节点位置；
            head.next = pre;  // 让当前节点指向前一个节点位置，完成反转
            pre = head;       // pre 往右走
            head = next;      // 当前节点往右继续走
        }
        return pre;
    }
}
