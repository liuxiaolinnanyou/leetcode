package 栈;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 输入: [1,null,2,3]
 * 输出: [1,3,2]
 */
public class 二叉树的中序遍历 {
    public static void main(String[] args) {
        // int[] arr = {1, null, 2, 3};     不兼容的类型
        Integer[] arr = {1, null, 2, 3};
    }

    // 递归    左 根 右
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private static void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }


    // 迭代   了解
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode pre = null;
        while (root != null) {
            // 如果左节点不为空，就将当前节点连带右子树全部挂到
            // 左节点的最右子树下面
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                // 将root指向root的left
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
                // 左子树为空，则打印这个节点，并向右边遍历
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
