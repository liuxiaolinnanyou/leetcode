package 十轮;

import java.util.Arrays;

/**
 * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * <p>
 * 注意:
 * 给定 0 和 1 的数量都不会超过 100。
 * 给定字符串数组的长度不会超过 600。
 * <p>
 * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * 输出: 4
 * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
 * <p>
 * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
 * 输出: 2
 * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
 */
public class 一和零 {
    public static void main(String[] args) {
        String[] arr1 = {"10", "0001", "111001", "1", "0"};
        String[] arr2 = {"10", "0", "1"};
        System.out.println(findMaxForm(arr1, 5, 3));
        System.out.println(findMaxForm(arr2, 1, 1));
    }

    // dp，其实就是暴力迭代。dp就是带备忘录的暴力循环
    // 二维背包问题
    // m 个 0，n 个 1 可以看作是背包，而字符串数组 strs 是物品列表
    // 则对于每一个物品(str)，都有放进背包(背包的容量要变成m-zeros,n-ones)和不放进背包两种选择,
    // 其中 zeros 表示 str 中 0 的个数，ones 表示 str 中 1 的个数
    // 则有状态: dp(i,j,k)代表用j个0，k个1组装strs[0...i]的最大个数
    // 动态转移方程: dp(i,j,k) = max(dp(i-1,j,k),dp(i-1,j-zeros,k-ones))

    // 首先这是一个复杂一点的背包问题，m个0，n个1 可以看作是背包，而字符串数组strs是物品列表
    // 则对于每一个物品(str)，都有放进背包(背包的容量要变成m-numsOfStr0,n-numsOfStr1)和
    // 不放进背包两种选择,其中numsOfStr0表示str中0的个数，numsOfStr1表示str中1的个数
    public static int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0 || (m == 0 && n == 0)) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < str.toCharArray().length; i++) {
                if (str.toCharArray()[i] == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }
        return dp[m][n];
    }
}
