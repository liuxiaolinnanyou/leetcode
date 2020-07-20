package 达西;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class 全排列 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
//        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }

    // 回溯    “全排列”就是一个非常经典的“回溯”算法的应用。我们知道，N 个数字的全排列一共有 N! 这么多个。
    // 一种通过探索所有可能的候选解来找出所有的解的算法。如果候选解被确认不是一个解的话（或者至少不是最后一个解），
    // 回溯算法会通过在上一步进行一些变化抛弃该解，即回溯并且再次尝试。
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n,
                                 ArrayList<Integer> output,
                                 List<List<Integer>> res,
                                 int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}