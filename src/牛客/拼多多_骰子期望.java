package 牛客;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 扔n个骰子，第i个骰子有可能投掷出Xi种等概率的不同的结果，数字从1到Xi。所有骰子的结果的最大值将作为最终结果。求最终结果的期望。
 * <p>
 * 输入描述：
 * 第一行一个整数n，表示有n个骰子。（1 <= n <= 50）
 * 第二行n个整数，表示每个骰子的结果数Xi。(2 <= Xi <= 50)
 * 输出描述：
 * 输出最终结果的期望，保留两位小数。
 * <p>
 * 输入：
 * 2
 * 2 2
 * 输出：
 * 1.75
 */
public class 拼多多_骰子期望 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] X = new int[num];
        for (int i = 0; i < num; i++) {
            X[i] = sc.nextInt();
        }
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        String p = decimalFormat.format(qiwang(X));

        System.out.println(p);
    }

    private static double qiwang(int[] x) {
        int len = x.length;
        double n = 1;
        for (int value : x) {
            n = n * value;
        }
        Arrays.sort(x);
        double qiwang = 0;
        while (x[len - 1] != 1) {
            double a = 1;
            for (int i = 0; i < len - 1; i++) {
                a = a * x[i];
            }
            qiwang += a * x[len - 1];
            x[len - 1] -= 1;
            Arrays.sort(x);
        }
        qiwang += 1;
        return qiwang / n;
    }
}
