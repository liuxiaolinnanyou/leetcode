package 笔试.天翼云;

import java.util.Scanner;

/**
 * 给定一个整数列表，在列表中挑选任意个数的值，使得挑选出值的和最大，要求挑选的值在原列表中不能相邻
 * <p>
 * 输入：一个整数列表，以逗号分割
 * 输出：最大和的值
 * <p>
 * 输入：1,2,3,4,5
 * 输出：9
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(",");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int max = help(arr);
        System.out.println(max);
    }

    public static int help(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], nums[i] + dp[i - 1]);
        }
        return dp[nums.length];
    }
}