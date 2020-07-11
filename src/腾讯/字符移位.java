package 腾讯;

import java.util.Scanner;

/**
 * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 * 你能帮帮小Q吗？
 * <p>
 * 输入描述：
 * 输出描述：
 * <p>
 * 输入：AkleBiCeilD
 * 输出：kleieilABCD
 */
public class 字符移位 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < length - i; j++) {
                    if ((chars[j - 1] >= 'A' && chars[j - 1] <= 'Z') && (chars[j] < 'A' || chars[j] > 'Z')) {
                        char temp = chars[j - 1];
                        chars[j - 1] = chars[j];
                        chars[j] = temp;
                    }
                }
            }
            System.out.println(String.valueOf(chars));
        }


        // 方法 2
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s = sc.nextLine();
//            System.out.println(getResult(s));
//        }
    }

    public static String getResult(String s) {
        return s.replaceAll("[A-Z]", "") + s.replaceAll("[a-z]", "");
    }
}
