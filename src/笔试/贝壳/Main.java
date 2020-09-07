package 笔试.贝壳;

import java.util.Scanner;

/**
 * 牛牛和牛妹聚在一起玩石头剪刀布的游戏，游戏一共进行了T个回合，每个回合牛牛和牛妹都会在背后用双手分别做出
 * 相对应的石头、剪刀、布的姿势，然后两个人挑一只手同时伸出，比较大小关系。
 * 由于牛妹的好胜心十分强，所以想让拥有透视眼的你告诉她，每个回合出左手还是右手胜率更高一些，为了方便处理，
 * 平局可以视为牛妹输（牛妹只想赢，连平局都不想要）。
 * <p>
 * 第一行输入一个正整数T(1 <= T <=1000)，代表回合数量。
 * 每个回合输入4个大写字母，前两个代表牛妹左，右手选择的是剪刀、石头、还是布。后两个代表牛牛左、右手选择的是
 * 剪刀、石头还是布。剪刀、石头和布分别用 J S B 表示。
 * <p>
 * 每个回合，如果牛妹出左手的胜率高，则输出left，如果右手的胜率高则输出right，如果胜率相同，则输出same。
 * <p>
 * 输入：
 * 1
 * S J J B
 * 输出：
 * same    说明：如果牛妹出左手，那么牛妹有胜率，如果牛妹出右手，也有胜率，所以胜率相同。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int l = 0;
        int r = 0;
        for (int i = 0; i < t; i++) {
            int left = 0;
            int right = 0;
            String[] all = sc.nextLine().split(" ");
            if (compare(all[0], all[2])) {
                left++;
            }
            if (compare(all[0], all[3])) {
                left++;
            }
            if (compare(all[1], all[2])) {
                right++;
            }
            if (compare(all[1], all[3])) {
                right++;
            }
            if (left > right) {
                System.out.println("left");
            } else if (left == right) {
                System.out.println("same");
            } else {
                System.out.println("right");
            }
        }
    }

    public static boolean compare(String f, String m) {
        if ((f.equals("S") && m.equals("J")) ||
                (f.equals("J") && m.equals("B")) ||
                (f.equals("B") && m.equals("S"))) {
            return true;
        }
        return false;
    }
}