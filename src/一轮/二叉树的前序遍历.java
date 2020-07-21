package 一轮;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 输入: [1,null,2,3]
 * 输出：[1,2,3]
 */
// 前序 中序 后序遍历
public class 二叉树的前序遍历 {
    public static void main(String[] args) {

    }

    // 前序遍历     递归
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private static void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }


    // 迭代
    public static List<Integer> preorderTraversal2(TreeNode root) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        TreeNode p = root;
//        List<Integer> res = new ArrayList<>();
//        while (p != null || !stack.isEmpty()) {
//            while (p != null) {
//                res.add(p.val);
//                stack.push(p);
//                p = p.left;
//            }
//            p = stack.pop().right;
//        }
//        return res;


        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            // 应该先打印左子树，然后右子树。所以先加入Stack的就是右子树，然后左子树
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
