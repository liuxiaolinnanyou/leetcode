package 笔试.五八同城;

// 实现层序遍历
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(printNode(n1));
    }

    public static ArrayList<ArrayList<Integer>> printNode(TreeNode node) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (node == null) {
            return new ArrayList<>();
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            ArrayList<Integer> curArrayList = new ArrayList<>();
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode curNode = queue.remove(0);
                curArrayList.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            result.add((ArrayList<Integer>) curArrayList.clone());
        }
        return result;
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