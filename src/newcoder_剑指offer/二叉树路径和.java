package newcoder_剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
// (注意: 在返回值的list中，数组长度大的数组靠前)
public class 二叉树路径和 {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(list));
        }
        // 因为在每一次的递归中，我们使用的是相同的result引用，所以其实左右子树递归得到的结果我们不需要关心，
        // 可以简写为FindPath(root.left, target)；FindPath(root.right, target)；
        // 但是为了大家能够看清楚递归的真相，此处我还是把递归的形式给大家展现了出来。
//        ArrayList<ArrayList<Integer>> result1 = findPath(root.left, target);
//        ArrayList<ArrayList<Integer>> result2 = findPath(root.right, target);
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(list.size() - 1);    // 去除最后一个
        return result;
    }
}
