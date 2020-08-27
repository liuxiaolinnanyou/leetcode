package 笔试.科大讯飞;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 定义一个n*m的数字矩阵，要求你在当中找到两个不在同一行同一列的数字，使得乘积最大。
 * 输入描述：
 * 第一行数字n , m 表示矩阵的大小
 * 接下来有n行数字，每行m个数字
 * 输出描述：
 * 一行一个数字表示这个最大的乘积。
 * <p>
 * 输入：
 * 2 2
 * 1 2
 * 3 4
 * 输出：
 * 6
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long res = 0;
        Row[] maxArr = new Row[n];
        int[][] arr = new int[n][m];     // 矩阵，用来存元素

        for (int i = 0; i < n; i++) {
            int maxV = 0;        // maxV 和 secMaxV 存储的分别是最大值和次最大值的索引
            int secMaxV = 0;
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][maxV] <= arr[i][j]) {
                    secMaxV = maxV;
                    maxV = j;
                }
            }
            maxArr[i] = new Row(i, maxV, secMaxV);
        }

        Arrays.sort(maxArr, (a, b) -> (arr[b.row][b.max] == arr[a.row][a.max] ? arr[b.row][b.secMax] - arr[a.row][a.secMax] : arr[b.row][b.max] - arr[a.row][a.max]));

        if (maxArr[0].max != maxArr[1].max) {
            System.out.println((long) arr[maxArr[0].row][maxArr[0].max] * (long) arr[maxArr[1].row][maxArr[1].max]);
        } else {
            long temp = (long) arr[maxArr[0].row][maxArr[0].max] * (long) arr[maxArr[1].row][maxArr[1].secMax];
            long temp2 = (long) arr[maxArr[0].row][maxArr[0].secMax] * (long) arr[maxArr[1].row][maxArr[1].max];
            System.out.println(Math.max(temp, temp2));
        }
    }

    public static class Row {
        int row;
        int max;
        int secMax;

        public Row(int _r, int _m, int _sm) {
            row = _r;
            max = _m;
            secMax = _sm;
        }
    }
}