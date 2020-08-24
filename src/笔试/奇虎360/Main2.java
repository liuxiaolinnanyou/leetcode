package 笔试.奇虎360;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 旋转字符串
 * 在一张透明的纸上，写下一个字符串，然后将纸翻面，请你判断正面和反面看到的字符串是否
 * 在正反面看上去一样，必须要求每个字符是左右对称的，例如 W 是左右对称的，而 N 不是。
 * <p>
 * 输入：
 * ABA
 * AHA
 * HHA
 * 输出：
 * NO
 * YES
 * NO
 * <p>
 * s的长度小于等于100，数据组数不会超过20
 */
public class Main2 {
    public static void main(String[] args) {
        Character[] arr = {'A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y'};
        List<Character> characters = Arrays.asList(arr);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            boolean flag = false;    // 放在外面只能通过 82
            String s = sc.nextLine();
            if (s.length() == 0) {
                System.out.println("YES");
            }
            if (s.equals(new StringBuilder(s).reverse().toString())) {
                for (int i = 0; i < s.length(); i++) {
                    if (characters.contains(s.charAt(i))) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}