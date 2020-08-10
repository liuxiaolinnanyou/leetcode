package 笔试.阿里;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
            index = (n + 1) / 2;
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