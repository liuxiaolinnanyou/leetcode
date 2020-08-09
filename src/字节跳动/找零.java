package 字节跳动;

import java.util.Scanner;

/**
 * Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。
 * 现在小Y使用1024元的纸币购买了一件价值为 N (0< N <=1024)的商品，请问最少他会收到多少硬币？
 * <p>
 * 输入描述:
 * 一行，包含一个数 N。
 * 输出描述:
 * 一行，包含一个数，表示最少收到的硬币数。
 * <p>
 * 输入例子1:
 * 200
 * 输出例子1:
 * 17
 * 例子说明1:
 * 花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。
 */
public class 找零 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            // 计算需要组成多少钱
//            int num = 1024 - sc.nextInt();
//            // dp[i] 状态定义为找i元钱，需要的最少张数，从 0 - num 总共 num + 1种
//            int[] dp = new int[num + 1];
//            // 初始化dp数组，因为要找最小值，这里给每个位置赋最大值，即都是由1元组成的，即num/1
//            for (int i = 0; i < dp.length; i++) {
//                dp[i] = i;
//            }
//            // 定义钱的集合，方便遍历
//            int[] money = {1, 4, 16, 64};
//
//            // 状态转移方程 从 1 ~ num
//            for (int i = 1; i <= num; i++) {
//                // dp[num]的最小值就是能组成它的前一步 + 1 和 本身进行比较
//                for (int j = 0; j < money.length; j++) {
//                    if (i - money[j] >= 0) {
//                        dp[i] = Math.min(dp[i - money[j]] + 1, dp[i]);
//                    }
//                }
//            }
//            System.out.println(dp[num]);
//        }

        // solution 方法
        System.out.println(solution(200));
        System.out.println(solution(123));
    }

    // 自己写的
    public static int solution(int num) {
        int[] arr = {64, 16, 4, 1};
        int count = 0;
        int money = 1024 - num;
        for (int i = 0; i < arr.length; i++) {
            while (money >= arr[i]) {
                money -= arr[i];
                count++;
            }
        }
        return count;
    }
}
