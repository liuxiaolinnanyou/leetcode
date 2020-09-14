package 笔试.五八同城;

import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> printNode(TreeNode node) {
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