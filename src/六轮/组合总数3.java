package 六轮;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class 组合总数3 {
    public static void main(String[] args) {

    }

    // 回溯
    public static List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private static void helper(int k, int residue, int start, List<Integer> path, List<List<Integer>> res) {
        if (residue == 0 && k == 0) {    // 这里是说总和已经达到了 n，而且满足 path 里面的个数满足了 k 个情况
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (residue - i < 0) break;
            path.add(i);
            helper(k - 1, residue - i, i + 1, path, res);  // path 增加了一个，相应的 k 减少了一个，总和 n 也减少了 i，然后往下迈进一步（i + 1）
            path.remove(path.size() - 1);                           // 撤销上一个操作
        }
    }

    // 不知道为什么加上 static 就通过不了
    // 方法 2    深搜 + 剪枝
    // 一个方法三个参数，k个数、拼凑成n,从<code>start</code>到9这几个数中选。
    static List<List<Integer>> ans = new ArrayList<>();
    // 尽量不要使用遗留类 Stack , Deque 可以实现 Stack 功能。
    static Deque<Integer> path = new ArrayDeque<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return ans;
    }

    private static void dfs(int k, int n, int start) {
        if (k < 0 || n < 0) {
            return;
        }
        // 刚好k个数、刚好递减成0（说明这k个数累加和刚好为n)
        if (k == 0 && n == 0) {
            if (!path.isEmpty())
                ans.add(new ArrayList<>(path));
            return;
        }

        // 从start开始，到9的范围，然后就是递归分支（选、不选) 记得恢复状态
        for (int i = start; i < 10; i++) {
            path.push(i);
            dfs(k - 1, n - i, ++start);
            path.pop();
        }
    }
}