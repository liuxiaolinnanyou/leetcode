package 笔试.华为;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 对输入 n 个无符号整数，进行二进制的移位和调换进行加扰，加扰后仍然保持 n 个整数。
 * 输出加扰后的 n 个整数，两个整数之间空格隔开。
 * <p>
 * 加扰步骤：
 * 1：先把每个整数每两个 bit 交换位置，如 bit0 和 bit1 交换，bit2 和 bit3 交换，以此类推。
 * 2：再把每个整数向右移 2 位，溢出的部分，第一个整数的最低 2 bit 移到第二个整数的最高两 bit 上，以此类推。
 * 无符号整数的范围不超过 32 bit 整数的大小。
 * <p>
 * 输入描述：
 * 输入 n 个无符号整数，两个整数直接用空格分开。n 不超过1000.
 * <p>
 * 输出描述：
 * 输出加扰后的无符号整数，两个整数直接用空格分开。
 * <p>
 * 输入：
 * 1 2
 * 输出：
 * 1073741824 2147483648
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            int len = split.length;

            String[] arr = new String[len];
            int[] res = new int[32 * len];

            for (int i = 0; i < len; i++) {
                arr[i] = Integer.toBinaryString(Integer.parseInt(split[i]));
            }
//            System.out.println(Arrays.toString(arr));
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length(); j++) {
                    if (arr[i].charAt(j) == '1') {
                        res[i * 32 - arr[i].length() + 32 + j] = 1;
                    }
                }
            }
//            System.out.println(Arrays.toString(res));
            for (int i = 0; i < res.length; i += 2) {
                int temp = res[i];
                res[i] = res[i + 1];
                res[i + 1] = temp;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]);
            }
            String str = sb.toString();
            String ans = str.substring(str.length() - 2) + str.substring(0, str.length() - 2);
//            System.out.println(ans);
            long[] resA = new long[len];
            int i = 0;
            while (ans.length() != 0) {
                String s1 = ans.substring(0, 32);
                ans = ans.substring(32);
                resA[i++] = Long.parseLong(s1, 2);
            }
//            System.out.println(Arrays.toString(resA));
            StringBuilder result = new StringBuilder();
            for (int x = 0; x < resA.length; x++) {
                result.append(resA[x]).append(" ");
            }
            System.out.println(result.toString().trim());
        }
    }
}