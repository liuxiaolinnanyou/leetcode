package 华为;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 请设计一个算法完成两个超长正整数的加法。
 * <p>
 * 输入描述:
 * 输入两个字符串数字
 * 输出描述:
 * 输出相加后的结果，string型
 * <p>
 * 输入
 * 99999999999999999999999999999999999999999999999999
 * 1
 * 输出
 * 100000000000000000000000000000000000000000000000000
 */
public class Hw78_超长正整数相加 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(addLongInteger(s1, s2));
            System.out.println(addLongInteger3(s1, s2));
        }
    }

    // BigInteger
    public static String addLongInteger(String str1, String str2) {
        BigInteger a = new BigInteger("0");
        BigInteger bigInteger = new BigInteger(str1);
        BigInteger bigInteger1 = new BigInteger(str2);
        if (bigInteger.compareTo(a) > 0 && bigInteger1.compareTo(a) > 0) {
            bigInteger = bigInteger.add(bigInteger1);
            String str = String.valueOf(bigInteger);
            return str;
        }
        return null;
    }

    // 方法 2
    public static String addLongInteger2(String str1, String str2) {
        int lenA = str1.length();
        int lenB = str2.length();
        int lenS = Math.max(lenA, lenB);     // 存放两个字符串长度的较大值

        // arrS保存最终生成的结果
        int[] arrA = new int[lenS];
        int[] arrB = new int[lenS];
        int[] arrS = new int[lenS + 1];

        for (int i = 0; i < lenA; i++) {
            arrA[i] = str1.charAt(lenA - 1 - i) - '0';
        }

        for (int i = 0; i < lenB; i++) {
            arrB[i] = str2.charAt(lenB - 1 - i) - '0';
        }

        for (int i = 0; i < lenS; i++) {
            int sum = arrS[i] + arrA[i] + arrB[i];
            int flag = sum / 10;
            arrS[i] = sum % 10;
            arrS[i + 1] += flag;
        }

        String s = "";
        for (int i = arrS[lenS] == 0 ? 1 : 0; i < lenS + 1; i++) {
            s += arrS[lenS - i];
        }
        return s;
    }

    public static String addLongInteger3(String str1, String str2) {
        int lenA = str1.length();
        int lenB = str2.length();
        int lenS = Math.max(lenA, lenB);

        int[] arr1 = new int[lenS];
        int[] arr2 = new int[lenS];
        int[] res = new int[lenS + 1];

        for (int i = 0; i < lenA; i++) {
            arr1[i] = str1.charAt(lenA - 1 - i) - '0';
        }

        for (int i = 0; i < lenB; i++) {
            arr2[i] = str2.charAt(lenB - 1 - i) - '0';
        }

        for (int i = 0; i < lenS; i++) {
            int sum = arr1[i] + arr2[i] + res[i];
            int flag = sum / 10;
            res[i] = sum % 10;
            res[i + 1] += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = res[lenS] == 0 ? 1 : 0; i < lenS + 1; i++) {
            sb.append(res[lenS - i]);
        }
        return sb.toString();
    }
}