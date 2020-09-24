package 三轮;

/**
 * 1.判断头结点是否为需要删除的元素，为防止链表开头有多个元素均为指定元素，所以使用while循环判断
 * 2.判断头结点是否为空，
 * 3.声明一个prev节点，prev.next节点为当前判断的节点，
 * 如果当前节点的值等于指定元素，那么直接用prev.next.next替换prev.next；
 * 如果不相等，则执行prev = prev.next，判断的下一个节点;
 */
public class 删除单链表中的指定元素 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        System.out.println(removeElements(a, 1));
        System.out.println(removeElements(a, 3));
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}