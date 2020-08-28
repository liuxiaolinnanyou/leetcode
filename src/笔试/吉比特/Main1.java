package 笔试.吉比特;

import java.util.Scanner;

/**
 * 1 1 1 1
 * 1 1
 * 1 1
 * 1 1
 * 3 3 3
 * <p>
 * 1 2 3 1
 * 4 5
 * 6 7
 * 8 9
 * 37 33 22
 */
public class Main1 {
    // AC 0    给的测试用例都通过，但是提交通过不了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        int n = sc.nextInt();
        String s = sc.nextLine();
        String[] split = s.split(" ");
        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[1]);
        long c = Long.parseLong(split[2]);
        long n = Long.parseLong(split[3]);

        String[] strArr = new String[3];
        for (int i = 0; i < 3; i++) {
            strArr[i] = sc.nextLine();
        }

        long[][] arr = new long[3][2];
        for (int i = 0; i < 3; i++) {
            arr[i][0] = Long.parseLong(strArr[i].split(" ")[0]);
            arr[i][1] = Long.parseLong(strArr[i].split(" ")[1]);
        }
        long sumA = a;
        long sumB = b;
        long sumC = c;
        for (int i = 1; i <= n; i++) {
            sumA += (b * arr[1][0] + c * arr[2][0]);
            sumB += (a * arr[0][0] + c * arr[2][1]);
            sumC += (a * arr[0][1] + b * arr[1][1]);
        }
        System.out.println(sumA + " " + sumB + " " + sumC);
    }
}
