package 笔试.阿里;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一条直线道路上有 N 棵树，现要在这条道路上某个位置修建水塔，要求这 N 棵树所在的位置坐标到水塔的位置坐标总距离最短，
 * 请求出水塔位置坐标。(所有位置坐标均为整数)
 * <p>
 * 输入描述：
 * 第一行一个整数 N 。
 * 第二行共 N 个整数a1,a2,...aN表示 N 棵树的坐标。
 * 2 <= N <= 5*10^5   ai < 2^31
 * <p>
 * 输入：
 * 4
 * 0 1 4 6
 * 输出：
 * 9
 */
public class Main {
    // AC 60%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int index = 0;
        if (n % 2 == 0) {
            index = n / 2;
        }
        if (n % 2 == 1) {
            index = (n - 1) / 2;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(arr[index] - arr[i]);
        }
        System.out.println(sum);
    }
}
//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    long[] arr = new long[n];
//        for (int i = 0; i < n; i++) {
//        arr[i] = sc.nextLong();
//        }
//        int min = Integer.MAX_VALUE;
//        for (long i = arr[0]; i <= arr[n - 1]; i++) {
//        int sum = 0;
//        for (int j = 0; j < arr.length; j++) {
//        sum += Math.abs(i - arr[j]);
//        }
//        min = Math.min(min, sum);
//        }
//        System.out.println(min);


//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//        arr[i] = sc.nextInt();
//        }
//        Arrays.sort(arr);
//        int index = 0;
//        if (n % 2 == 0) {
//        index = n / 2;
//        }
//        if (n % 2 == 1) {
//        index = (n - 1) / 2;
//        }
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//        sum += Math.abs(arr[index] - arr[i]);
//        }
//        System.out.println(sum);