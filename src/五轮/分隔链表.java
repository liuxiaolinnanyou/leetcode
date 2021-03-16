package 五轮;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class 分隔链表 {
    public static void main(String[] args) {

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode minLink = new ListNode(0);  // 记录小值链表的头
        ListNode minP = minLink;                // 对小表操作用的指针

        ListNode maxnLink = new ListNode(0); // 记录大值链表的头
        ListNode maxP = maxnLink;               // 同理

        while (head != null) {
            if (head.val < x) {                 // 找到小的值
                minP.next = head;               // 放入minLink中，操作指针后移一位
                minP = head;
//                minP = minP.next;
            } else {
                maxP.next = head;              // 放入maxLink中，操作指针后移一位
                maxP = head;
            }
            head = head.next;
        }
        // 遍历完成后记得后一段链表的最后节点指向null;
        maxP.next = null;
        // 两段拼接
        minP.next = maxnLink.next;
        return minLink.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
