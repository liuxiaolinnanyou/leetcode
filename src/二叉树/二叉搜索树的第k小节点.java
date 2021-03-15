package 二叉树;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第 k 小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为 4。
 */
public class 二叉搜索树的第k小节点 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(8);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        System.out.println(kthNode(root, 3));
    }

    public static TreeNode kthNode(TreeNode Root, int k) {
        if (Root == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();  // 建立栈
        TreeNode cur = Root;
        // 中序遍历
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);        // 当前节点不为null，应该寻找左儿子
                cur = cur.left;
            } else {
                cur = stack.pop();      // 当前节点null则弹出栈内元素，相当于按顺序输出最小值。
                if (--k == 0) {         // 计数器功能
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}