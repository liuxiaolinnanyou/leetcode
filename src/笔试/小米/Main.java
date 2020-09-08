package 笔试.小米;

import java.util.Scanner;

/**
 * 注册网站时，需要使用包含不同类型(数字，符号，大写字母，小写字母)的字符，和特定长度，检查一个密码内容同时包含以上4种类型的字符
 * 并且长度在8-120个字符之间，符合要求，返回0，长度不符合返回1，类型不符合要求返回2.
 * 可以一次输入多组密码，以空格符间隔，空格符不作为密码。
 * <p>
 * 输入：123 12345678 123abcABC!!!
 * 输出：
 * 1
 * 2
 * 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            char[] chars = split[i].toCharArray();
            if (chars.length < 8 || chars.length > 120) {
                System.out.println(1);
                continue;
            } else {
                boolean isNum = false;
                boolean isXiaoxie = false;
                boolean isDaxie = false;
                boolean other = false;
                for (char ch : chars) {
                    if (ch >= '0' && ch <= '9') {
                        isNum = true;
                    } else if (ch >= 'a' && ch <= 'z') {
                        isXiaoxie = true;
                    } else if (ch >= 'A' && ch <= 'Z') {
                        isDaxie = true;
                    } else {
                        other = true;
                    }
                }
                if (isNum && isXiaoxie && isDaxie && other) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(2);
                continue;
            }
        }
    }
}