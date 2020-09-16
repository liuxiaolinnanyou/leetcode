package newcoder_剑指offer;

// 操作给定的二叉树，将其变换为源二叉树的镜像。
public class 镜像二叉树 {
    public void mirror(TreeNode root) {
        // 交换左右子树的节点，然后递归调用该方法
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归
        mirror(root.left);
        mirror(root.right);
    }
}