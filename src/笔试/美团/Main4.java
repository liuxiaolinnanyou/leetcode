package 笔试.美团;

// 输入：10 7 3
//      FTFFFTFFFF

// 输出：6

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int m = Math.min(c1, c2);
        sc.nextLine();
        String s = sc.nextLine();
        String[] split = s.split("T");
        long res = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() < 3) {
                continue;
            }
            if (split[i].length() >= 3) {
                long ans = split[i].length() / 3;
                res += ans;
            }
        }
        System.out.println(m * res);
    }
}