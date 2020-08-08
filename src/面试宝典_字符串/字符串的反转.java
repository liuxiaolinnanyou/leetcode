package 面试宝典_字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 把一个句子中的单词进行反转，例如："how are you",反转后变成"you are how"。
 */
public class 字符串的反转 {
    public static void main(String[] args) {
        String s = "how are you";
        System.out.println(swapWords(s));
        System.out.println(swapWords2(s));
//        System.out.println("--------------------------");
//        StringBuilder sb = new StringBuilder();
//        for (int i = s.length() - 1; i >= 0; i--) {
//            sb.append(s.charAt(i));
//        }
//        System.out.println(sb.toString());
    }

    public static String swapWords(String s) {
        char[] charArr = s.toCharArray();
        // 对整个字符串进行字符反转操作
        swap(charArr, 0, charArr.length - 1);

        int begin = 0;
        // 对每个单词进行字符反转操作
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                swap(charArr, begin, i - 1);
                begin = i + 1;
            }
        }
        // 最后一个单词的反转
        swap(charArr, begin, charArr.length - 1);
        return new String(charArr);
    }


    // 字符数组反转
    private static void swap(char[] charArr, int front, int end) {
        while (front < end) {
            char temp = charArr[end];
            charArr[end] = charArr[front];
            charArr[front] = temp;
            front++;
            end--;
        }
    }

    // 自己写的
    public static String swapWords2(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
