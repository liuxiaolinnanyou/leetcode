package 笔试.有赞;

import java.util.Arrays;

/**
 * 给你一个整数数组nums，请你找出并返回能被5整除的元素最大和。
 * <p>
 * 输入：[3,6,5,1,8]
 * 输出：20   选出6,5,1,8
 * <p>
 * 输入：[6]
 * 输出：0
 * <p>
 * 输入：[1,2,3,4,4]
 * 输出：10   选出1,2,3,4   或者2,4,4
 * <p>
 * 1 <= nums.length <= 4*10^4
 * 1 <= nums[i] <= 10^4
 */
// 力扣原题：https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/solution/onjie-fa-by-igamegum/
public class Main1 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 5, 1, 8};
        System.out.println(maxSumDivFive(arr));
    }

    /**
     * 不妨设dp[i] 代表 选取的数字累加和 模3 = i 的数字和
     * 假定nums[i] % 3 = 1 ，那么，和 前面选取的数字和模 3 = 2 的数相加，
     * 就可以模3为 0 ，表达起来就是 dp[0] = max(dp[0], nums[i] + dp[2])
     * 依次类推，只要不断更新 dp 数组即可，注意一点，更新的时候要保存上一个状态的值，避免后续更新的时候重复影响。
     */
    public static int maxSumDivFive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] % 5 != 0) {
            return 0;
        }

        int[] dp = {0, 0, 0, 0, 0};   // 模 5 为 0 1 2 3 4
        for (int i = 0; i < nums.length; ++i) {
            int mod = nums[i] % 5;
            int a = dp[(5 + 0 - mod) % 5];
            int b = dp[(5 + 1 - mod) % 5];
            int c = dp[(5 + 2 - mod) % 5];
            int d = dp[(5 + 3 - mod) % 5];
            int e = dp[(5 + 4 - mod) % 5];

            if (a > 0 || mod == 0) {
                dp[0] = Math.max(dp[0], a + nums[i]);
            }
            if (b > 0 || mod == 1) {
                dp[1] = Math.max(dp[1], b + nums[i]);
            }
            if (c > 0 || mod == 2) {
                dp[2] = Math.max(dp[2], c + nums[i]);
            }
            if (d > 0 || mod == 3) {
                dp[3] = Math.max(dp[3], d + nums[i]);
            }
            if (e > 0 || mod == 4) {
                dp[4] = Math.max(dp[4], e + nums[i]);
            }
        }
        return dp[0];
    }
}
