package 笔试.伴鱼;

/**
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的**负二进制（base -2）**表示。
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 * 输入：2
 * 输出："110"
 * 解释：(-2) ^ 2 + (-2) ^ 1 = 2
 * <p>
 * 输入：3
 * 输出："111"
 * 解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * <p>
 * 输入：4
 * 输出："100"
 * 解释：(-2) ^ 2 = 4
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(baseNeg2(2));
        System.out.println(baseNeg2(3));
        System.out.println(baseNeg2(4));
        System.out.println("------------");
        System.out.println(baseNeg(2));
        System.out.println(baseNeg(3));
        System.out.println(baseNeg(4));
    }

    public static String baseNeg2(int N) {
        // write code here
        // N 为 0 或 1 的判断
        if (N == 0) {
            return "0";
        }
        if (N == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (N == 0) {
                break;
            }
            sb.append(Math.abs(N % 2));
            if (N > 0) {
                N = N / (-2);
            } else {
                double a = Math.ceil(N / (double) -2);
                N = (int) a;
            }
        }
        return sb.reverse().toString();
    }

    public static String baseNeg(int N) {
        String res = "";
        while (N != 0) {
            // res = Integer.toString(N & 1) + res;
            res = (N & 1) + res;
            N = -(N >> 1);
        }
        return res == "" ? "0" : res;
    }
}