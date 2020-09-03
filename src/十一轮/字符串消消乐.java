package 十一轮;

/**
 * 字符串消消乐，将字符串中相邻相同的字符一起消掉，最后输出消除完成的字符串。
 * 示例：abcccbxezzzrf7788fn
 * 输出：axern
 * 说明：从左住右消除，第一趟消除相邻相同的“ccc”、“zzz”、“77”、“88”，得到abbxerffn，
 * 第二趟消除相邻相同的“bb”、“ff”，得到axern，不存在相邻相同字符，消除结束。
 */
public class 字符串消消乐 {
    public static void main(String[] args) {
//        System.out.println(doReduce("abcccbxezzzrf7788fn"));
        System.out.println(doReduce("abbccd"));
    }

    public static String doReduce(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder strBuilder = new StringBuilder(s);
        if (strBuilder != null && strBuilder.length() != 0) {
            strBuilder.append(" ");
            // 是否有相临相同匹配
            boolean same = false;
            // 相临相同匹配首字符
            char c = strBuilder.charAt(0);
            for (int i = 1; i < strBuilder.length(); i++) {
                if (c == strBuilder.charAt(i)) {
                    same = true;
                } else {
                    if (!same) {
                        sb.append(c);
                    }
                    c = strBuilder.charAt(i);
                    same = false;
                }
            }
            // 匹配完成，如果字符串长度没变则说明没有需要继续消除的了，否则递归继续消除
            if (sb.length() + 1 < strBuilder.length()) {
                return doReduce(sb.toString());
            }
        }
        return sb.toString();
    }
}
