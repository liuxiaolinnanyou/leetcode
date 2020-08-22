package 笔试.滴滴;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 斐波那契蛇   n < 10
// 输入：3
// 输出:
// 34 21 13
// 1 1 8
// 2 3 5
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] arr = new long[n][n];
        List<Long> list = new ArrayList<>();
        list.add((long) 1);
        list.add((long) 1);
        long a = 1;
        long b = 1;
        for (int i = 3; i <= n * n; i++) {
            long c = a + b;
            a = b;
            b = c;
            list.add(c);
        }
//        Collections.sort(list);
        Collections.reverse(list);
//        System.out.println(list);

        int up = 0;
        int down = arr.length - 1;
        int left = 0;
        int right = arr[0].length - 1;
        int i = 0;
        while (true) {
            // 最上面一行
            for (int col = left; col <= right; col++) {
                arr[up][col] = list.get(i);
                i++;
            }
            // 向下逼近
            up++;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最右边一行
            for (int row = up; row <= down; row++) {
                arr[row][right] = list.get(i);
                i++;
            }
            // 向左逼近
            right--;
            // 判断是否越界
            if (left > right) {
                break;
            }
            // 最下面一行
            for (int col = right; col >= left; col--) {
                arr[down][col] = list.get(i);
                i++;
            }
            // 向上逼近
            down--;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最左边一行
            for (int row = down; row >= up; row--) {
                arr[row][left] = list.get(i);
                i++;
            }
            // 向右逼近
            left++;
            // 判断是否越界
            if (left > right) {
                break;
            }
        }
        List<String> listStr = new ArrayList<>();
        for (int x = 0; x < n; x++) {
            String s = "";
            for (int y = 0; y < n; y++) {
                s += arr[x][y];
                s += " ";
            }
            listStr.add(s);
        }
        for (String s : listStr) {
            System.out.println(s.trim());
        }
    }


    // 陶鹏鹏代码
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 0) {
            return;
        }
        long[] dp = new long[n * n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n * n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        long[] dop = new long[n * n + 1];
        for (int i = n * n; i >= 1; i--) {
            dop[i] = dp[n * n + 1 - i];
        }
        long[][] matrix = new long[n][n];
        spiralOrder(matrix, dop);
    }

    public static void spiralOrder(long[][] matrix, long[] nums) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            matrix[row][column] = nums[i + 1];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        for (int i = 0; i < matrix.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            System.out.println(sb);
        }
    }
}