package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 选择匹配符
 */
public class RegExp03 {
    public static void main(String[] args) {
        String content = "liuxiaolin 刘 柳树";
        String regStr = "liu|刘|柳";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}