package 牛客;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 多多鸡打算造一本自己的电子字典，里面的所有单词都只由a和b组成。
 * 每个单词的组成里a的数量不能超过N个且b的数量不能超过M个。
 * 多多鸡的幸运数字是K，它打算把所有满足条件的单词里的字典序第K小的单词找出来，作为字典的封面。
 * <p>
 * 输入描述：共一行，三个整数N, M, K。(0 < N, M < 50, 0 < K < 1,000,000,000,000,000)
 * 输出描述：共一行，为字典序第K小的单词。
 * <p>
 * 输入：2 1 4
 * 输出：ab
 * 说明：
 * 满足条件的单词里，按照字典序从小到大排列的结果是
 * a
 * aa
 * aab
 * ab
 * aba
 * b
 * ba
 * baa
 */
public class 拼多多_多多的电子字典 {
    public static void main(String[] args) {
        BigInteger[][] dp = new BigInteger[50][50];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long K = sc.nextLong();
        for (int i = 0; i <= N; i++) {
            dp[i][0] = new BigInteger(Integer.toString(i));
        }
        for (int i = 0; i <= M; i++) {
            dp[0][i] = new BigInteger(Integer.toString(i));
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // dp[i][j] = 1+dp[i-1][j] + 1+ dp[i][j-1];
                dp[i][j] = dp[i - 1][j].add(dp[i][j - 1]).add(new BigInteger("2"));
            }
        }
        StringBuilder sb = new StringBuilder();
        int n = N, m = M;
        long k = K;
        while (k > 0) {
            if (n > 0 && m > 0) {
                if (dp[n - 1][m].compareTo(new BigInteger(Long.toString(k - 1))) >= 0) {//k<=dp[n-1][m]+1
                    k--;
                    sb.append('a');
                    n--;
                } else { // k>dp[n-1][m]+1
                    k -= dp[n - 1][m].longValue() + 2;
                    sb.append('b');
                    m--;
                }
            } else if (n > 0 && m == 0) {
                k--;
                sb.append('a');
                n--;
            } else if (n == 0 && m > 0) {
                k--;
                sb.append('b');
                m--;
            } else {
                k = 0;
            }
        }
        System.out.println(sb.toString());
    }
}
