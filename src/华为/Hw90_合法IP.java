package 华为;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，
 * 每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），
 * 如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 * 现在需要你用程序来判断IP是否合法。
 * <p>
 * 输入描述:
 * 输入一个ip地址
 * 输出描述:
 * 返回判断的结果YES or NO
 * <p>
 * 输入
 * 10.138.15.1
 * 输出
 * YES
 */
public class Hw90_合法IP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(check(s));
        }
    }

    public static String check(String s) {
        boolean flag = true;
        String[] split = s.split("\\.");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] <= 255) {
                continue;
            } else {
                flag = false;
                break;
            }
        }
        return flag ? "YES" : "NO";
    }
}
