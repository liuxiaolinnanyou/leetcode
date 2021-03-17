package 笔试.瑛太莱;

// 现有一个 m*n 的数组，请按斜对齐打印数组。
// 1  2  3  4
// 5  6  7  8
// 9  10 11 12

// 输出：1,2,5,3,6,9,4,7,10,8,11,12

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n - 1; i++) {
            int y = i < n ? i : n - 1;
            int x = i - y;
            while (y >= 0 && x < m) {
                sb.append(arr[x][y] + ",");
                y--;
                x++;
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
