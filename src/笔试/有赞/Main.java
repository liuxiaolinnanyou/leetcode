package 笔试.有赞;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 输入：{1,2}
 * 输出：false
 * <p>
 * 输入：{1,2,2,1}
 * 输出：true
 * <p>
 * 空链表以及只含单个元素的链表可以认为是回文链表。
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] arr = new int[count];
        int index = 0;
        while (head != null) {
            arr[index++] = head.val;
            head = head.next;
        }
        boolean flag = false;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] == arr[arr.length - 1 - i]) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}