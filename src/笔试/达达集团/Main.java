package 笔试.达达集团;

/**
 * 输入：
 * 1
 * 5
 * 1,30
 * 2,22
 * 17,24
 * 14,29
 * 13,45
 * 13,32
 * 输出：
 * 17,24
 * 14,29
 * <p>
 * 输入：
 * 2
 * 5
 * 15,20
 * 4,12
 * 17,24
 * 14,29
 * 23,45
 * 13,22
 * 输出：
 * 15,20
 * 17,24
 * 14,29
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int method = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split(",");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }
        String s = sc.nextLine();
        sc.close();
        String[] split = s.split(",");
        int x1 = Integer.parseInt(split[0]);
        int x2 = Integer.parseInt(split[1]);
        if (method == 1) {        // 查询被包含在指定区间内的线段列表
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] > x1 && arr[i][1] < x2) {
                    System.out.println("" + arr[i][0] + "," + arr[i][1]);
                }
            }
        } else {                 // 查找所有和指定线段有重叠的线段列表
            for (int i = 0; i < arr.length; i++) {
                if (Math.max(arr[i][0], x1) <= Math.min(arr[i][1], x2)) {
                    System.out.println("" + arr[i][0] + "," + arr[i][1]);
                }
            }
        }
    }
}