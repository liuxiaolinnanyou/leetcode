package 笔试.奇虎360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 魔塔闯关
 * 魔塔有 n 关，而你可以自由选择前往攻略哪一关，每一关只能获得一次分数，第 i 关攻略完成后你将会获得 Ai 的分数。
 * 某些关有一个特殊的宝物，你只能在攻略完这一关的时候使用这个宝物(也可以不使用，额外的宝物并不能留到其他关卡使用)
 * 这个宝物将使这一关不得分，但是将你现有的总得分乘以 2 作为新的得分。你现在知道了所有关卡的通关方法，也知道了每一关的
 * 得分和是否有宝物，你现在想知道怎样选择攻略的顺序和使用宝物的方法，才能让自己的得分最大化。
 * <p>
 * 输入描述：
 * 输入第一行包含一个整数 n
 * 接下来 n 行每行两个整数 Ai，Bi 表示第 i 关的分数，若 Bi 为 1，则第 i 关有宝物。
 * <p>
 * 输出描述：
 * 获得的最大分数
 * <p>
 * 输入：
 * 5
 * 1 1
 * 3 1
 * 5 1
 * 2 0
 * 2 0
 * 输出：
 * 36
 * <p>
 * n <= 100  1 <= Ai <= 10^7  0 <= b <= 1  数据保证最多不超过 30 个宝物
 * 5,4,3,2(用宝物),1(用宝物)
 */
public class Main3 {
    public static class CheckPoint {
        long score;
        int jiabei;

        public CheckPoint(long s, int j) {
            score = s;
            jiabei = j;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CheckPoint[] checks = new CheckPoint[n];
        for (int i = 0; i < n; i++) {
            long s = sc.nextLong();
            int j = sc.nextInt();
            checks[i] = new CheckPoint(s, j);
        }
        Arrays.sort(checks, (a, b) -> (a.jiabei == b.jiabei ? (int) (b.score - a.score) : a.jiabei - b.jiabei));
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (res == 0 || checks[i].jiabei == 0) {
                res += checks[i].score;
            } else {
                res = Math.max(res * 2, res + checks[i].score);
            }
        }
        System.out.println(res);
        return;
    }
}