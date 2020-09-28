package vivo_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 小v在公司负责游戏运营，今天收到一款申请新上架的游戏“跳一跳”，为了确保提供给广大玩家朋友们的游戏都是高品质的，
 * 按照运营流程小v必须对新游戏进行全方位了解体验和评估。这款游戏的规则如下：
 * 有n个盒子排成了一行，每个盒子上面有一个数字a[i]，表示在该盒子上的人最多能向右移动a[i]个盒子（比如当前所在盒子上的数字是3，
 * 则表示可以一次向右前进1个盒子，2个盒子或者3个盒子）。
 * <p>
 * 现在小v从左边第一个盒子上开始体验游戏，请问最少需要移动几次能到最后一个盒子上？
 * <p>
 * 输入描述：
 * 输入 ：2 2 3 0 4
 * 表示现在有5个盒子，上面的数字分别是2, 2, 3, 0, 4。
 * 输出描述：
 * 输出：2
 * 小v有两种跳法：
 * 跳法1：盒子1 -> 盒子2 -> 盒子3 -> 盒子5，共3下
 * 跳法2：盒子1 -> 盒子3 -> 盒子5，共2下
 * 跳法2的步骤数最少，所以输出最少步数：2。
 * <p>
 * 输入：2 2 3 0 4
 * 输出：2
 */
public class 跳盒子 {
    public static void main(String[] args) throws IOException {
//        int[] arr = {2, 2, 3, 0, 4};
//        System.out.println(solution(arr));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int[] input = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] s) {
        if (s == null || s.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[s.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(s[i]);
        }
        return intArr;
    }


    // 动态规划法
    public static int solution(int[] input) {
        if (input.length == 1) {
            // 如果只有一个盒子，那么起点即为终点，无需跳跃
            return 0;
        }
        if (input.length > 1 && input[0] == 0) {
            // 如果不只一个盒子，那么肯定需要跳动。但是起点位置能跳跃的距离为0
            // 那么肯定到不了终点
            return -1;
        }

        // 下面的代码处理需要跳动才能到达终点的情况
        int[] dp = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            // 计算能够到达最右的盒子
            int range = Math.min(input.length - 1, i + input[i]);
            for (int j = i + 1; j <= range; j++) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        int ret = dp[input.length - 1];
        // 需要跳动的次数至少大于0，结果出现跳动0次，说明不可达，返回-1
        return ret == 0 ? -1 : ret;
    }
}