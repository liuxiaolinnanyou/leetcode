package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 求第k层的节点个数 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(getKLevelSize(root, 3));
    }

    public static int getKLevelSize(TreeNode root, int k) {
//        if (root == null) {
//            return 0;
//        } else if (k == 1) {
//            return 1;
//        }
//        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode res = root;
        queue.add(res);
        int lavel = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (lavel == k) {
                return size;
            }
            lavel += 1;
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return 0;
    }
}