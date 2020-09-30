package 笔试.招银网络科技;

public class 判断链表是否有环 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l3.next = l5;
        l5.next = l6;
        l6.next = l3;
        System.out.println(isLinkedListContainsLoop(l1));
        System.out.println("--------------------------");
        System.out.println(findLinkedListLoopBegin(l1));
    }

    public static boolean isLinkedListContainsLoop(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 找到环的入口点
    public static ListNode findLinkedListLoopBegin(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean isLinkedListContainsLoop = false;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isLinkedListContainsLoop = true;
                break;
            }
        }
        if (isLinkedListContainsLoop) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    // 求环的大小(长度)
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}