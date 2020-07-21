package 一轮;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class 最大子序和 {
    public static void main(String[] args) {

    }

    // 动态规划首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
    // 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
    // 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
    // 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
    public static int maxSubArray(int[] nums) {
//        int ans = nums[0];
//        int sum = 0;
//        for (int num : nums) {
//            if (sum > 0) {
//                sum += num;
//            } else {
//                sum = num;
//            }
//            ans = Math.max(ans, sum);
//        }
//        return ans;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
