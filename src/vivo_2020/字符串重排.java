package vivo_2020;

/**
 * 给定一个字符串，分三种场景进行处理。
 * 1.如果字符串中包含数字字符 0 ，将视作输入结束，忽略后续字符，将数字 0 前的字符按 ASCII 码从小到大顺序进行排序输出。
 * 2.如果字符串中不包含数字字符 0 ，那么将整个字符串的字符按 ASCII 码从小到大顺序进行排序输出。
 * 3.如果进行排序的字符串中包含除数字字母以外的类型，则统一输出字符串 WRONG INPUT。
 * <p>
 * 输入：1923dha0
 * 输出：1239adh
 */
public class 字符串重排 {
    public static void main(String[] args) {
        System.out.println(orderString("1923dha0"));
    }

    // 未验证正确性
    // 0-9   48-57
    // a-z   97-122
    // A-Z   65-90
    public static String orderString(String given_str) {
        return "";
    }
}