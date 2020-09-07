package 笔试.贝壳;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 你需要构造出一个特定的字符串，有以下两种方法：
 * 1.添加任意一个字符
 * 2.复制粘贴之前添加的所有字符，且该方法只能使用一次。现在想知道最少需要多少步可以完成构造。
 * <p>
 * 输入描述：
 * 一个整数n，表示字符串长度
 * 一个长度为n的字符串
 * 1 <= n <= 100000
 * 输出描述：
 * 一个整数，表示最少需要的步骤数。
 * <p>
 * 输入：
 * 6
 * abcdef
 * 输出：
 * 6
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String string = scanner.nextLine();
        Pattern pattern = Pattern.compile("(.*)\\1.*");
        Matcher matcher = pattern.matcher(string);
        String copy = null;
        if (matcher.find()) {
            copy = matcher.group(1);
        }
        if (copy.length() == 0) {
            System.out.println(n);
        } else {
            System.out.println(copy.length() + 1 + (n - copy.length() * 2));
        }
    }
}