package vivo_2020;

/**
 * 小v最近在玩一款挖矿的游戏，该游戏介绍如下：
 * 1、每次可以挖到多个矿石，每个矿石的重量都不一样，挖矿结束后需要通过一款平衡矿车运送下山；
 * 2、平衡矿车有左右2个车厢，中间只有1个车轮沿着导轨滑到山下，
 * 且矿车只有在2个车厢重量完全相等且矿石数量相差不超过1个的情况下才能成功运送矿石，否则在转弯时可能出现侧翻。
 * <p>
 * 假设小v挖到了n（n<100）个矿石，每个矿石重量不超过100，为了确保一次性将n个矿石都运送出去，
 * 一旦矿车的车厢重量不一样就需要购买配重砝码。请问小v每次最少需要购买多少重量的砝码呢?
 * （假设车厢足够放下这些矿石和砝码，砝码重量任选）
 * <p>
 * 输入描述：输入n个正整数表示每个矿石的重量
 * 输出描述：输出一个正整数表示最少需要购买的砝码重量
 * <p>
 * 输入：3 7 4 11 8 10
 * 输出：1
 * 说明：小v可以将重量3,7和11的矿石放到左车厢，重量4，8和10 放到右车厢，然后购买重量为1的砝码放到左车厢
 */
public class 运矿石 {
    public static void main(String[] args) {
        int[] arr = {3, 7, 4, 11, 8, 10};
        System.out.println(solution(arr));
    }

    // 动态规划
    public static int solution(int[] input) {
        int sum = 0;
        int n = input.length;
        for (int weight : input) {
            sum += weight;
        }
        int rows = (n + 1) / 2;
        int cols = sum / 2;
        int[][] dp = new int[rows + 1][cols + 1];
        // 初始化
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            int weight = input[i];
            for (int j = Math.min(rows, i + 1); j > 0; j--) {     // 注意
                for (int k = cols; k >= weight; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - 1][k - weight] + weight);
                }
            }
        }
        if ((n & 1) == 0) {
            return sum - dp[rows][cols] * 2;
        }
        return sum - Math.max(dp[rows][cols], dp[rows - 1][cols]) * 2;
    }
}