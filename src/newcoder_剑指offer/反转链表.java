package newcoder_剑指offer;

import java.util.ArrayList;

// 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class 反转链表 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;

//        System.out.println(printListFromTailToHead(a));
//        System.out.println("------------------------");
        System.out.println(printListFromTailToHead2(a));
    }

    // 方法1    头插法
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode temp = listNode;
        while (temp != null) {
            list.add(0, temp.val);
            temp = temp.next;
        }
        return list;
    }

    // 方法2      递归
    static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
//        ArrayList<Integer> list = new ArrayList<Integer>();       ArrayList 不能定义在函数里面 这样每次都会创建一个新的
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}