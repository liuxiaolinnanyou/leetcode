package newcoder_剑指offer;

// 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class 合并链表 {
    public static void main(String[] args) {
        String s = "abssd";
        System.out.println(s.replace('a', 'e'));   // 只是一个返回值，没有改变 s 的值
        System.out.println(s);                                      // 字符串一旦被赋值就不能被改变
    }

    // 方法 1     借助额外的链表
    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode h = new ListNode(-1);
        ListNode cur = h;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;       // 链表的每一个节点都是一个引用类型，这里不能存链表节点的 val
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return h.next;
    }

    // 方法 2    不需要借助额外的链表
    public static ListNode merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val < list2.val) {
                list1.next = merge2(list1.next, list2);
                return list1;
            } else {
                list2.next = merge2(list1, list2.next);
                return list2;
            }
        }
    }
}

