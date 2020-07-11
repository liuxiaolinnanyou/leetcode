package 快手;

import java.util.Scanner;

/**
 * 给定一组石头，每个石头有一个正数的重量。每一轮开始的时候，选择两个石头一起碰撞，假定两个石头的重量为x，y，x<=y,碰撞结果为
 * 1. 如果x==y，碰撞结果为两个石头消失
 * 2. 如果x != y，碰撞结果两个石头消失，生成一个新的石头，新石头重量为y-x
 * 最终最多剩下一个石头为结束。求解最小的剩余石头质量的可能性是多少。
 * <p>
 * 输入描述：
 * 第一行输入石头个数(<=100)
 * 第二行输入石头质量，以空格分割，石头质量总和<=10000
 * 输出描述：
 * 最终的石头质量
 * <p>
 * 输入：
 * 6
 * 2 7 4 1 8 1
 * 输出：
 * 1
 */
public class 石头碰撞 {
    /**
     * 思路，利用0-1背包方法求出能将石头合并成2堆的情况，dp[j]代表是否能将石头分成其中一堆为j，
     * 另一堆为(sum-j)，其中一堆的最小值肯定不超过总和的一半，最后最接近的两堆即为最小值
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int result = 0;
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];      // 石头的总质量
        }

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++)
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }

        for (int j = sum / 2; j >= 0; j--)
            if (dp[j]) {
                result = Math.abs(j - (sum - j));
                break;
            }
        System.out.println(result);
    }
}