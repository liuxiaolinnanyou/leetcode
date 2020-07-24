package 华为;

import java.util.Scanner;

/**
 * 如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 * 实现以下接口：
 * 输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
 * 按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出
 * 清空目前的统计结果，重新统计
 * 调用者会保证：
 * 输入的字符串以‘\0’结尾。
 * <p>
 * 输入描述:
 * 输入一串字符。
 * 输出描述:
 * 对字符中的各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,
 * 如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 * <p>
 * 输入：aadddccddc
 * 输出：dca
 */
public class Hw102_字符统计 {
    public static void main(String[] args) {
        // ascii 的范围 0-127
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int[] mat = new int[256];
            for (int i = 0; i < str.length(); i++) {
                if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9' || str.charAt(i) == ' ')) {
                    int pos = str.charAt(i);
                    mat[pos]++;
                }
            }
            int max = 0;
            for (int i = 0; i < 256; i++) {
                if (mat[i] > max)
                    max = mat[i];
            }
            String res = "";
            for (int j = max; j > 0; j--) {
                for (int k = 0; k < 256; k++) {
                    if (mat[k] == j)
                        res += (char) k;
                }
            }
            System.out.println(res);
        }
        in.close();
    }
}