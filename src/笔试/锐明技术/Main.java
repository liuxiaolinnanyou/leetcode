package 笔试.锐明技术;

/**
 * 查询两个字符串最大相同的字符串的长度
 * <p>
 * 输入："fdsagrewqg","fdsdgrewwg"
 * 输出：4
 * <p>
 * 字符串不会为null
 * 最大相同字符串一定是连续的
 * 字符串长度不超过10000
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findMaxMatchStringLength("fdsagrewqg", "fdsdgrewwg"));
    }

    public static int findMaxMatchStringLength(String str1, String str2) {
        // write code here
        char[] chars = str1.toCharArray();
        char[] chars1 = str2.toCharArray();
        int[][] dp = new int[chars.length][chars1.length];
        for (int i = 0; i < dp.length; i++) {
            if (chars[i] == chars1[0]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (chars[0] == chars1[i]) {
                dp[0][i] = 1;
            }
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (chars[i] == chars1[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}