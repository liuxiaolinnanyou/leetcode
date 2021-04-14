package 笔试.华为;

/**
 * 无线设备传输过程中，数据经常需要通过各种中继设备进行中转。
 * 现有某段传输路径，每隔1km放置1个中继设备用于数据中转，现用
 * 一数组来描述包括起始点的所有中继设备的最大传输距离（单位km）
 * 求从起点到终点，能完成信号传输的最少中转次数。
 * <p>
 * 输入描述：
 * 入参通过多行字符串方式表示，例如：
 * 4
 * 2 3 1 1
 * 字符串含义：
 * 第一行表示总共中转设备台数：总计4台。
 * 第二行表示各中转设备的最大传输能力。
 * <p>
 * 输出描述：
 * 从起点到终点，能完成信号传输的最少中转次数
 * <p>
 * 输入：
 * 6
 * 2 5 1 1 1 1
 * 输出：
 * 2
 * <p>
 * 说明：从1号设备中转到2号设备，2号直接到6号。
 */

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] distancesStr = sc.nextLine().split(" ");

        int[] arr = new int[distancesStr.length];
        for (int i = 0; i < distancesStr.length; i++) {
            arr[i] = Integer.parseInt(distancesStr[i]);
        }
        int ans = solution(arr);
        System.out.println(ans);
//        System.out.println(solution2(arr));
    }

    // 思路：每个位置的元素都有一个能够到达的最远距离，当 i == end 的时候即是能够抵达最远距离的时候。
    public static int solution(int[] arr) {
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < arr.length - 1; i++) {           // 不需要访问最后一位元素
            maxPosition = Math.max(maxPosition, i + arr[i]);
            if (i == end) {
                step++;
                end = maxPosition;
            }
        }
        return step;
    }

    // 跳盒子问题
    public static int solution2(int[] input) {
        if (input.length == 1) {
            return 0;
        }
        if (input.length > 1 && input[0] == 0) {
            return -1;
        }

        int[] dp = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            int range = Math.min(input.length - 1, i + input[i]);
            for (int j = i + 1; j <= range; j++) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        int ret = dp[input.length - 1];
        return ret == 0 ? -1 : ret;
    }
}