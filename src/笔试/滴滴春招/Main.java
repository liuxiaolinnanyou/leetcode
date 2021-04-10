package 笔试.滴滴春招;

/**
 * 优秀的操作系统离不开优秀的任务调度算法。现在，有一台计算机即将执行n个任务，每个任务都
 * 有一个准备阶段和执行阶段。只有在准备阶段完成后，执行阶段才可以开始。同一时间，计算机只
 * 能执行一个任务的执行阶段，同时可以执行任意多个任务的准备阶段。请你设计一个算法，合理分配
 * 任务执行顺序，并输出完成所有任务的最少时间。
 * <p>
 * 输入描述：
 * 第一行一个整数n表示任务的数量（1 <= n <=50000）
 * 接下来n行每行两个整数a，b表示第i个任务的准备时长和执行时长。 （1 <= a,b <= 10^9）
 * 输出描述：
 * 仅一行一个整数，表示执行所有任务的最少时间。
 * <p>
 * 输入：
 * 2
 * 5 1
 * 2 4
 * 输出：
 * 7
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
//        for (int[] num : arr) {
//            System.out.println(Arrays.toString(num));
//        }
        long res = arr[0][0] + arr[0][1];
        for (int i = 1; i < n; i++) {
            if (res > arr[i][0]) {
                res += arr[i][1];
            } else {
                res += (arr[i][0] - res) + arr[i][1];
            }
        }
        System.out.println(res);
    }
}