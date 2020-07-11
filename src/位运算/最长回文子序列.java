package 位运算;

/**
 * 最长回文子序列：给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 * 最长回文子序列和最长回文子串的区别是，子串是字符串中连续的一个序列，而子序列是字符串
 * 中保持相对位置的字符序列，例如："bbbb"可以是字符串"bbbab"的子序列但不是子串。
 * <p>
 * 输入："bbbab"
 * 输出：4
 * <p>
 * 输入："cbbd"
 * 输出：2
 */
public class 最长回文子序列 {
    public static void main(String[] args) {
        String s1 = "bbbab";
        String s2 = "cbbd";
        System.out.println(longestPalindromeSubseq(s1));
        System.out.println(longestPalindromeSubseq(s2));
    }

    // 动态规划法
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}

