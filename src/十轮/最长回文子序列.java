package 十轮;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * <p>
 * 输入："bbbab"
 * 输出：4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 输入："cbbd"
 * 输出：2
 * 一个可能的最长回文子序列为 "bb"。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 */
public class 最长回文子序列 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
        System.out.println("--------------------------------");
        System.out.println(longestPalindromeSubseq2("bbbab"));
        System.out.println(longestPalindromeSubseq2("cbbd"));
    }

    // 动态规划法
    public static int longestPalindromeSubseq(String s) {
        if (s == null) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 从下往上遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 那么就说明在原先的基础上又增加了回文子序列的长度
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                // 表明这时dp[i][j]只需取两者之间的最大值即可
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static int longestPalindromeSubseq2(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];   // 最长公共子序列
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}
