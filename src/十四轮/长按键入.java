package 十四轮;
// 力扣 925

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * <p>
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * <p>
 * 说明：
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 */
public class 长按键入 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleelx"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0 && typed.length() == 0) {
            return true;
        } else if (name.length() == 0 || typed.length() == 0) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < name.length() || j < typed.length()) {
            if (i < name.length() && j < typed.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0 && j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        return i == name.length() && j == typed.length();
    }
}