package 笔试.科大讯飞;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 排序
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        String s = sc.nextLine();
        String[] split = s.split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
