package newcoder_剑指offer;

// 输入一个链表，输出该链表中倒数第k个结点。
public class 输出链表的第k个节点 {
    public static void main(String[] args) {

    }

    // 方法 1
    public static ListNode findKthToTail(ListNode head, int k) {
        // 倒数第k个是正数第 length-k+1 个
        // 先进行判断节点总的数量，然后再从前向后找第 n-k+1 个节点
        int totalNum = 0;
        if (head != null) {
            totalNum++;
        } else {
            return null;
        }
        // 计算总的节点数量
        ListNode currentNode = head.next;
        while (currentNode != null) {
            totalNum++;
            currentNode = currentNode.next;
        }
        if (totalNum < k) {
            // throw new RuntimeException("k的值超过了链表长度");
            return null;
        }
        // 倒数第 k 个为正数第 totalNum-k+1 个
        ListNode resultNode = head;
        for (int i = 1; i <= totalNum - k; i++) {
            resultNode = resultNode.next;
        }
        return resultNode;
    }


    // 方法 2
    public static ListNode findKthToTail2(ListNode head, int k) {
        // 快指针先往前走k步，注意判断边界，然后快慢一起走，当快指针为none的时候，慢指针走到了倒数第k个节点
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;       // 加上这句是为了解决 k 值大于链表的长度  例如 {1,2,3,4,5}   6
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 方法 3
    public static ListNode findKthToTail3(ListNode head, int k) {
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k) {
                q = q.next;
            }
            p = p.next;
        }
        return i < k ? null : q;
    }
}
