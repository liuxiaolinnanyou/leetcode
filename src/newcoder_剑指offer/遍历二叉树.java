package newcoder_剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class 遍历二叉树 {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        // 用一个队列来存储这些曾经访问过但是仍旧有用的节点。
        // 应该难就难在在各个编程语言中队列的实现，尤其如果要用C++或者C来编程那就更难了，
        // 所以这道题目在锻炼了解题思路的同时也让我对Java中对Queue这个高级数据结构的实现有了进一步的了解
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);                      // 将指定的元素插入此队列
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return result;
    }
}
