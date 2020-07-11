package newcoder_剑指offer;

// 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class 替换字符串空格 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(sb));
        System.out.println(replaceSpace2(sb));
    }

    // 方法 1
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    // 方法 2
    public static String replaceSpace2(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < str.length(); x++) {
            char ch = str.charAt(x);
            if (ch == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
