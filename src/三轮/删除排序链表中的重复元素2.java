package 三轮;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class 删除排序链表中的重复元素2 {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        // 若head为空则直接返回null
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);                   // 建立一个虚拟头结点
        ListNode tail = dummy;                                 // 定义一个尾巴，用于尾插法。
        for (ListNode l = head, r = head; l != null; l = r) {
            while (r != null && r.val == l.val) {
                r = r.next;
            }   // 只要r不为空并且与l的值相等则一直向后移动
            if (l.next == r) {                                // 若长度为1，则通过尾插法加入。
                tail.next = l;                                // 基本的尾插法
                tail = l;
                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
            }
        }
        return dummy.next;
    }


    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 用哈希表记录每个节点值的出现频率
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ListNode p = head;
        while (p != null) {
            int val = p.val;
            if (cache.containsKey(val)) {
                cache.put(val, cache.get(val) + 1);
            } else {
                cache.put(val, 1);
            }
            p = p.next;
        }
        // 将所有只出现一次的值放到arr中，之后再对这个arr排序
        for (Integer k : cache.keySet()) {
            if (cache.get(k) == 1) {
                arr.add(k);
            }
        }
        Collections.sort(arr);
        ListNode dummy = new ListNode(-1);
        p = dummy;
        // 创建长度为arr.length长度的链表，依次将arr中的值赋给每个链表节点
        for (Integer i : arr) {
            ListNode tmp = new ListNode(i);
            p.next = tmp;
            p = p.next;
        }
        return dummy.next;
    }
}
