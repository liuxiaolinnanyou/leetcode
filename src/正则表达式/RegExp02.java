package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符匹配符的使用
 * java正则表达式默认是区分字母大小写的，如何实现不区分大小写
 * 1.(?i)abc    表示abc都不区分大小写   (i 代表大小写不敏感)
 * 2.a(?i)bc    表示bc不区分大小写
 * 3.a((?i)b)c  表示只有b不区分大小写
 * 4.Pattern compile = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
 */
public class RegExp02 {
    public static void main(String[] args) {
        String content = "a11c8ab cABC_&$@";
//        String regStr = "[a-z]";   // 匹配 a-z 之间的任意一个字符
//        String regStr = "[A-Z]";   // 匹配 A-Z 之间的任意一个字符
//        String regStr = "abc";     // 匹配 abc 字符串 （默认区分大小写）
//        String regStr = "(?i)abc";
//        String regStr = "\\w";      // 等价于[0-9a-zA-Z_]
//        String regStr = "\\W";      // 等价于[^0-9a-zA-Z_]
//        String regStr = "\\s";
        String regStr = "\\S";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}