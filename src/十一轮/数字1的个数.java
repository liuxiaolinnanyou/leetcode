package 十一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 */
public class 数字1的个数 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(countDigitOne(n));
    }

    // 超时   不通过
    public static int countDigitOne2(int n) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            sb.append(s);
        }
        char[] chars = sb.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count++;
            }
        }
        return count;
    }


    public static int countDigitOne(int n) {
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return count;
    }
}
