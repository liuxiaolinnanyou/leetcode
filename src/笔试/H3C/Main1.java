package 笔试.H3C;

/**
 * 现有一个星期的词库,实现一个输入联想功能，如输入"S"，则返回"Saturday Sunday"，但不返回"Tuesday"
 * 若词库无匹配则返回"No much"，查找时区分大小写。
 * <p>
 * 输入："S"
 * 输出："Saturday Sunday"
 */

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(character_auto_complete("S"));
    }

    public static String character_auto_complete(String str) {
        // write code here
        List<String> list = new ArrayList<>();
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.add("Sunday");
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            if (s.startsWith(str)) {
                sb.append(s).append(" ");
            }
        }
        if (sb.length() == 0) {
            return "No match";
        } else {
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
    }
}
