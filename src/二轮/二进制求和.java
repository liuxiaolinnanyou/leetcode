package 二轮;

import org.omg.CORBA.AnySeqHelper;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class 二进制求和 {
    public static void main(String[] args) {
        System.out.println(5 + '0');
        System.out.println('0' + 5);
        System.out.println(Integer.parseInt("1011", 2));     // 将字符串按二进制转换
    }

    public static String addBinary(String a, String b) {
        // 不通过
        // return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));

        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

    // (1) 从低位开始依次同时遍历两个字符串每一位求和并记录进位。
    // (2) 使用 StringBuilder 依次拼接每一位的运算结果。
    // (3) 遍历完成后将结果字符串翻转返回。
    public static String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        // 定义 tag 记录二进制运算的进位。
        int tag = 0;
        // 从后往前遍历两个字符串并计算依次拼接每一位。
        for (int i = charsA.length - 1, j = charsB.length - 1; i >= 0 || j >= 0; i--, j--) {
            int curr = tag;
            // 只有两个字符串没有遍历完，就累加当前位置的数值。
            curr += i >= 0 ? charsA[i] - '0' : 0;
            curr += j >= 0 ? charsB[j] - '0' : 0;
            // 当前位置的和除以 2 ，余数就留在当前位置，商就表示进位。
            sb.append(curr % 2);
            tag = curr / 2;
        }
        // 两个字符串都遍历完以后判断最后是否还有进位。
        sb.append(tag == 1 ? tag : "");
        // 将最终结果翻转后返回。
        return sb.reverse().toString();
    }
}