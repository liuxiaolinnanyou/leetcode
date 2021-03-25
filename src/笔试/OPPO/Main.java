package 笔试.OPPO;

// AC 80
// 正则表达式匹配
public class Main {
    public static void main(String[] args) {

    }

    public static boolean isMatchPattern(String testString, String pattern) {
        // write code here
        int n = testString.length();
        int m = pattern.length();
        boolean[][] f = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    if (pattern.charAt(j - 1) != '%') {
                        if (i > 0 && (testString.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '_')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        if (i >= 1 && j >= 2 && (testString.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '_')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
