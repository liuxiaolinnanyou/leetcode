package 笔试.携程;

// 86   超时
/**
 * 最大收益
 * 小A毕业后，回家继承了租车公司。现在小A的店内只剩下一辆汽车可出租，但是一天
 * 内有n个订单，每个订单的用车开始时间为第x小时，用车结束时间为第y小时，订单jine为z
 * 请你帮小A安排订单，计算小A可以获得的最大收益。
 * <p>
 * 第一行输入一个整数n，表示有n(1 <= n <= 10)个订单
 * 第二行读入用空格分隔的整数，表示订单的开始时间
 * 第三行读入用空格分隔的整数，表示订单的结束时间
 * 第四行读入用空格分隔的整数，表示订单金额。
 * <p>
 * 输入：
 * 4
 * 1 2 3 3
 * 3 4 5 6
 * 200 150 180 210
 * 输出：
 * 410
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scopeNum = sc.nextInt();
        int[] scores = new int[scopeNum];
        for (int i = 0; i < scopeNum; i++) {
            scores[i] = sc.nextInt();
        }
        int cardNum = sc.nextInt();
        Map<Integer, Integer> step2Count = new HashMap<>();
        for (int i = 0; i < cardNum; i++) {
            int step = sc.nextInt();
            int count = step2Count.getOrDefault(step, 0);
            count++;
            step2Count.put(step, count);
        }
        dfs(scores, step2Count, 0, scores[0]);
        System.out.println(res);
    }

    public static void dfs(int[] scores, Map<Integer, Integer> map, int pos, int score) {
        boolean flag = false;
        for (int step : map.keySet()) {
            int count = map.get(step);
            if (count == 0) {
                continue;
            }
            flag = true;
            if (pos + step >= scores.length) {
                if (score > res) {
                    res = score;
                }
                continue;
            }
            map.put(step, count - 1);
            dfs(scores, map, pos + step, score + scores[pos + step]);
            map.put(step, count);
        }
        if (!flag) {
            if (score > res) {
                res = score;
            }
        }
    }
}