package 达西;

import java.util.Scanner;

/**
 * 给定一个非空字符串s和一个缩写abbr，请校验它们是否匹配。假设字符串中只包含小写字母，
 * 缩写中只包含小写字母和数字。缩写中的数字表示其缩略的字符数，连续多位数字表示一个多位数。
 * 例如，字符串“word”的缩写有且仅有以下这些：
 * [“word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", “4"]。
 * <p>
 * 给出：s = "internationalization", abbr = "i12iz4n"
 * 返回：true。
 * <p>
 * 给出：s = "apple", abbr = "a2e"
 * 返回：false。
 */
public class 缩写校验 {
    // 用指针i,j分别指向s与abbr，若j所指位置为数字，则先求出当前数字的大小times，然后i跳过times个字符。
    // 如果j所指位置为字符，则直接判断两指针所指字符是否相等
    // 最后判断i，j是否都已经到末尾，若是返回true，否则说明匹配不上，返回false
    // 注意处理前导0的情况，在本题中前导0非法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(valid(s1, s2));
    }


    public static boolean valid(String word, String abbr) {
        char[] words = word.toCharArray();
        char[] abbrs = abbr.toCharArray();
        int i = 0;
        int j = 0;
        while (i < words.length && j < abbrs.length) {
            if (Character.isDigit(abbrs[j]) && abbrs[j] != '0') {
                int times = 0;
                int count = 1;
                while (j < abbrs.length && Character.isDigit(abbrs[j])) {
                    times = count * times + abbrs[j] - '0';
                    count = count * 10;
                    j++;
                }
                i = i + times;
            } else {    // z直接按位判断字符
                if (words[i] != abbrs[j]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        if (i == words.length && j == abbrs.length) {
            return true;
        }
        return false;
    }
}
