package 正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的语法
 * 如果要想灵活的运用正则表达式，必须了解其中各种元字符的功能，元字符从功能上大致分为：
 * 1.限定符
 * 2.选择匹配符
 * 3.分组组合和反向引用符
 * 4.特殊字符
 * 5.字符匹配符
 * 6.定位符
 */
// 用 $ 去匹配 "abc$("
// 用 ( 去匹配 "abc$("
public class RegExp01 {
    /**
     * 演示转义字符的使用
     * 需要用到转义符号的字符有以下：. * + ( ) $ / \ ? [ ] ^ { }
     * @param args
     */
    public static void main(String[] args) {
        String content = "abc$(a.bc(123(";
        // 匹配 (
//        String regStr = "\\(";
        String regStr = "\\.";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}