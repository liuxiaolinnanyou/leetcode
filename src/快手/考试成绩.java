package 快手;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 现在你的班级刚刚参加了一个只有单选题的考试。班级一共n个学生，考试有m个问题。每个题目都有5个可选答案（A，B，C，D，E）。
 * 并且每个题目只有一个正确答案。每个题目的分数并不一样，第i个题目的分数用a[i]表示。如果题目没答对该题会获得0分。
 * 考试结束后，每个学生都记得自己的答案，但是他们还不知道正确答案是什么。如果非常乐观的考虑，他们班级最多可能得到多少分呢？
 * <p>
 * 输入描述：
 * 第一行包含2个正整数，n和m。(1 <= n, m <= 1000，n是班级中学生数量，m是题目的数量)
 * 下面n行数据每行包含一个string si，表示第i个学生的答案。si的第j个字符表示该学生第j个题目的答案。
 * 输出描述：
 * 一个正整数，全班学生最大的可能获得的分数总和。
 * <p>
 * 输入：
 * 2 4
 * ABCD
 * ABCE
 * 1 2 3 4
 * 输出：
 * 16
 * 说明：最优的答案是ABCD，这样2个学生的总分是16。
 * <p>
 * 输入：
 * 3 3
 * ABC
 * BCD
 * CDE
 * 5 4 12
 * 输出：
 * 21
 * 说明：最优的答案是CCC，3个学生的总分是5+4+12=21
 */
public class 考试成绩 {
    // 重点在于求班级同学每道题公共答案最多的选项然后依次乘以score里每道题的分值就是最大和了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] str = new String[n];
        int[] score = new int[m];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        for (int i = 0; i < m; i++) {
            score[i] = sc.nextInt();
        }
        System.out.println(maxScore(n, m, str, score));
    }

    private static int maxScore(int n, int m, String[] str, int[] score) {
        int res = 0;
        int index = 0;
        for (int i = 0; i < m; i++) {
            // 每题有5个答案   对应5个答案
            int[] count = {0, 0, 0, 0, 0};
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (str[j].charAt(i) == 'A') {
                    max = max > ++count[0] ? max : count[0];
                } else if (str[j].charAt(i) == 'B') {
                    max = max > ++count[1] ? max : count[1];
                } else if (str[j].charAt(i) == 'C') {
                    max = max > ++count[2] ? max : count[2];
                } else if (str[j].charAt(i) == 'D') {
                    max = max > ++count[3] ? max : count[3];
                } else if (str[j].charAt(i) == 'E') {
                    max = max > ++count[4] ? max : count[4];
                }
            }
            res += max * score[index++];
        }
        return res;
    }


//    // 使用 HashMap 求每一个题目答案相同的最大人数
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        sc.nextLine();    // 解决先获取数字再获取字符串存在的问题
//        char[][] ans = new char[n][m];
//        for (int i = 0; i < n; i++) {
//            String s = sc.nextLine();
//            ans[i] = Arrays.copyOf(s.toCharArray(), m);
//        }
//        int[] score = new int[m];
//        for (int i = 0; i < m; i++) {
//            score[i] = sc.nextInt();
//        }
//        int res = 0;
//        for (int j = 0; j < m; j++) {
//            int tmp = 0;
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < n; i++) {
//                int key = ans[i][j] - 'A';
//                if (map.containsKey(key)) {
//                    int t = map.get(key);
//                    map.put(key, t + 1);
//                    tmp = Math.max(tmp, t + 1);
//                } else {
//                    map.put(key, 1);
//                    tmp = Math.max(1, tmp);
//                }
//            }
//            res += tmp * score[j];
//        }
//        System.out.println(res);
//    }
}
