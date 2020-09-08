package newcoder_剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

// 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class 反转链表 {
    public static void main(String[] args) {

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
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
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