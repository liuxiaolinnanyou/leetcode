package 腾讯;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class 回文子串 {
    public static void main(String[] args) {

    }

    // 动态规划
    public static int countSubstring(String s) {
        int ans = 0;
        int n = s.length();
        int j;
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = true;
                    ans++;
                } else {
                    if (cs[i] == cs[j]) {
                        dp[i][j] = len == 2 ? true : dp[i + 1][j - 1];
                        if (dp[i][j]) ans++;
                    }
                }
            }
        }
        return ans;
    }

    // 中心扩展法
    public static int countSubstring2(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j)
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    ++res;
                }
        }
        return res;
    }
}