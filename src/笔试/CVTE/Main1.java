package 笔试.CVTE;

import java.util.Arrays;

/**
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 */
public class Main1 {
    public static void main(String[] args) {
        int[] arr = {110, 121, 111, 95, 98, 115, 118};
        System.out.println(lengthOfLIS(arr));
    }

    // dp[i] 的值代表 a 前 i 个数字的最长子序列长度
    public static int lengthOfLIS(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        int[] dp = new int[a.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}