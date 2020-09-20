package 笔试.度小满金融;

/**
 * 由于新冠肺炎疫情的爆发，小明养在宿舍的小昆虫已经很久很久都没有人管了。小昆虫已经饿的不行了，必须出来找东西吃，
 * 可是出来之后需要走出一个迷宫。小昆虫每次可以朝上、下、左、右四个方向之一走一步，且只要走出任意一条边界线即可逃出迷宫。
 * 这只小昆虫曾感染过X星的一种奇异病毒，目前还没有发现任何副作用，但是却拥有了一项特异功能——破坏障碍物。
 * 假设小昆虫在一个N*M的迷宫中，"@"代表小昆虫的初始位置，"."代表可以通过的空地，"*"代表可以破坏的障碍物，
 * "#"代表不可破坏的障碍物。请问小昆虫最少需要使用多少次特异功能才可以逃出迷宫？
 * <p>
 * 输入描述：
 * 多组数据，第1行有1个正整数T，表示有T组数据。（T<=100）
 * 对于每组数据，第1行有两个整数N和M。(1<=N, M<=1000)
 * 接着N行，每行有一个长度为M的字符串，表示N*M的迷宫。
 * 输出描述：
 * 输出一个整数，表示使用特异功能的最少次数。如果小昆虫不能走出迷宫，则输出-1。
 * <p>
 * 输入：
 * 3
 * 3 3
 * ###
 * #@*
 * ***
 * 3 4
 * ####
 * #@.*
 * **.*
 * 3 3
 * .#.
 * #@#
 * .#.
 * 输出：
 * 1
 * 0
 * -1
 */

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NumOfN = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < NumOfN; i++) {
            String NM[] = scanner.nextLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            String[] input = new String[N];
            for (int j = 0; j < N; j++) {
                input[j] = scanner.nextLine();
            }
            int result = function(N, M, input);
            System.out.println(result);
        }
    }

    private static int function(int n, int m, String[] input) {
        int[] result = {Integer.MAX_VALUE};
        int begini = 0;
        int beginj = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i].charAt(j) == '@') {
                    begini = i;
                    beginj = j;
                    break;
                }
            }
        }
        boolean[][] visite = new boolean[n][m];
        int step = 0;
        DFS(begini, beginj, n, m, input, visite, result, step);
        return result[0];
    }

    private static void DFS(int begini, int beginj, int n, int m, String[] input, boolean[][] visite, int[] result, int step) {
        if (step > result[0] || visite[begini][beginj] || input[begini].charAt(beginj) == '#') {
            return;
        }
        if (begini == 0 || begini == n - 1 || beginj == 0 || beginj == m - 1) {

            if (input[begini].charAt(beginj) == '*') step += 1;
            result[0] = Math.min(result[0], step);
            return;
        }

        visite[begini][beginj] = true;
        if (input[begini].charAt(beginj) == '.' || input[begini].charAt(beginj) == '@') {
            DFS(begini + 1, beginj, n, m, input, visite, result, step);
            DFS(begini - 1, beginj, n, m, input, visite, result, step);
            DFS(begini, beginj + 1, n, m, input, visite, result, step);
            DFS(begini, beginj - 1, n, m, input, visite, result, step);
        } else {
            DFS(begini + 1, beginj, n, m, input, visite, result, step + 1);
            DFS(begini - 1, beginj, n, m, input, visite, result, step + 1);
            DFS(begini, beginj + 1, n, m, input, visite, result, step + 1);
            DFS(begini, beginj - 1, n, m, input, visite, result, step + 1);
        }
        visite[begini][beginj] = false;
    }
}