package 六轮;

import java.util.Arrays;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 */
public class 从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return helper(inorder, postorder);
    }

    private static TreeNode helper(int[] in, int[] post) {
        if (in.length == 0) {
            return null;     // 递归出口
        }
        // 根据后序数组的最后一个元素，创建根节点
        TreeNode root = new TreeNode(post[post.length - 1]);
        // 在中序数组中查找值等于【后序数组最后一个元素】的下标
        for (int i = 0; i < in.length; ++i) {
            if (in[i] == post[post.length - 1]) {
                // 确定这个下标i后，将中序数组分成两部分，后序数组分成两部分
                int[] inLeft = Arrays.copyOfRange(in, 0, i);
                int[] inRight = Arrays.copyOfRange(in, i + 1, in.length);
                int[] postLeft = Arrays.copyOfRange(post, 0, i);
                int[] postRight = Arrays.copyOfRange(post, i, post.length - 1);
                // 递归处理中序数组左边，后序数组左边
                root.left = helper(inLeft, postLeft);
                // 递归处理中序数组右边，后序数组右边
                root.right = helper(inRight, postRight);
                break;
            }
        }
        return root;
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