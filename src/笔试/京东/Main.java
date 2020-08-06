package 笔试.京东;

import java.util.Scanner;

/**
 * 求下列数列的和：
 * f(n)=1/5-1/10+1/15-1/20+1/25-...+1/(5*(2*n-1))-1/(5*2*n)
 * <p>
 * 输入描述：
 * 单组输入，每组数据一个输入，每个输入一行，输入 n 。(n<=100)
 * 输出描述：
 * 输出数列前 n 项的和，结果四舍五入保留四位小数。
 * <p>
 * 输入：1
 * 输出：0.1000
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            if (n > 1000) {
//                System.out.printf("%.4f\n", 0.0);
//                continue;
//            }
//            double res = 0;
//            for (int i = 1; i <= n; i++) {
//                res += 1.0 / ((2 * n - 1) * 2 * n);
//            }
//            System.out.printf("%.4f\n", res / 5.0);
//        }
        double ans = 0;
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            ans += 1.0 / (5 * (2 * i - 1));
            ans -= 1.0 / (5 * 2 * i);
        }
        System.out.println(String.format("%.4f", ans));
    }
}
