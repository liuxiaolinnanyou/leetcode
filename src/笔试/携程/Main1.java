package 笔试.携程;

// 83
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

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String start = sc.nextLine();
        String end = sc.nextLine();
        String money = sc.nextLine();

        int[] startArr = new int[n];
        int[] endArr = new int[n];
        int[] moneyArr = new int[n];

        for (int i = 0; i < n; i++) {
            startArr[i] = Integer.parseInt(start.split(" ")[i]);
            endArr[i] = Integer.parseInt(end.split(" ")[i]);
            moneyArr[i] = Integer.parseInt(money.split(" ")[i]);
        }
        int longHour = 0;
        int[][] res = new int[n][3];
        for (int i = 0; i < n; i++) {
            res[i][0] = startArr[i];
            res[i][1] = endArr[i];
            res[i][2] = moneyArr[i];
            if (endArr[i] > longHour) {
                longHour = endArr[i];
            }
        }

        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int num1 = o1[0] - o2[0];
                int num2 = num1 == 0 ? o1[1] - o2[1] : num1;
                int num3 = num2 == 0 ? o2[2] - o1[2] : num2;
                return num3;
            }
        });

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }

        int[] ans = new int[longHour + 1];
        Arrays.fill(ans, 0);
        for (int i = 0; i < n; i++) {
            for (int j = res[i][1]; j < longHour + 1; j++) {
                if (j == res[i][1]) {
                    ans[j] = Math.max(Math.max(ans[j], ans[res[i][0]] + res[i][2]), ans[j - 1]);
                } else {
                    ans[j] = Math.max(ans[j], ans[j - 1]);
                }
            }
        }
//        System.out.println(Arrays.toString(ans));
        System.out.println(ans[longHour - 1]);
    }
}