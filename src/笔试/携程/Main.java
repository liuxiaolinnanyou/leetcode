package 笔试.携程;

// 86%   超时
/**
 * 周游世界
 * 1.节目组给出一组有序的全球旅游景点，到达该景点则将会获取不同的分数奖励。
 * 2.每位参赛者都位于旅游景点的第一站，默认获取该景点的分数奖励。
 * 3.每位参赛者会得到一组数值一样的卡片，每张卡片上有一个数字，1,2,3,或4，不同的数字代表可以从当前站点向后行进的步数。
 * 例如，当前处于第一站，若使用一张数字1的卡片，则到达第二站，若使用一张数字2的卡片，则到达第三站。
 * 很显然，这个游戏获胜的条件和卡片的使用顺序相关。
 * <p>
 * scores数组代表当前给出的各个景点的分数，cards数组代表当前给出的卡片。
 * <p>
 * 提示：
 * scores.length <= 100
 * cards中每一种卡片的数量不超过40
 * sum(cards[i])<=scores.length
 * <p>
 * 输入：
 * 4
 * 1 2 3 4
 * 2
 * 1 2
 * 输出：
 * 8
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