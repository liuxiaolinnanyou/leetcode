package 三轮;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class 删除排序链表中的重复元素 {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
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
                '}';
    }
}
