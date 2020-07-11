package JavaGuide算法;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 输入："A man, a plan, a canal: Panama"
 * 输出：true
 * <p>
 * 输入："race a car"
 * 输出：false
 */
public class 验证回文串 {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            // 从头和尾向中间遍历
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                // 字符不是字母和数字的情况
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                // 字符不是字母和数字的情况
                r--;
            } else {
                // 判断二者是否相等
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                // 满足两个位置的字符相等就继续往中间逼近
                l++;
                r--;
            }
        }
        return true;
    }
}
