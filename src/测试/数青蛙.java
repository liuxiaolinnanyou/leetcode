package 测试;

/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。
 * 由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 注意：
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。
 * 如果没有输出全部五个字母，那么它就不会发出声音。
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * <p>
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * <p>
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙
 * <p>
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 * <p>
 * 输入：croakOfFrogs = "croakcroa"
 * 输出：-1
 */
public class 数青蛙 {
    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("croakcroak"));
        System.out.println(minNumberOfFrogs("crcoakroak"));
        System.out.println(minNumberOfFrogs("croakcrook"));
        System.out.println(minNumberOfFrogs("croakcroa"));
    }

    /**
     * 思想就是维护croak的个数，如果遇到当前字母，则肯定是由前面字母过来，前面字母数-1。
     * 如遇到r，则必是c->r，所以c--
     * k代表结尾，其实也是青蛙的起始（一次喊叫结束），所以遇到c的时候，先去消耗k，没有k了，需要新青蛙，答案+1
     */
    public static int minNumberOfFrogs(String croakOfFrogs) {
        int c, r, o, a, k;
        c = 0;
        r = 0;
        o = 0;
        a = 0;
        k = 0;
        char[] chars = croakOfFrogs.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'c') {
                if (k > 0) {
                    k--;
                } else {
                    res++;
                }
                c++;
            } else if (chars[i] == 'r') {
                c--;
                r++;
            } else if (chars[i] == 'o') {
                r--;
                o++;
            } else if (chars[i] == 'a') {
                o--;
                a++;
            } else if (chars[i] == 'k') {
                a--;
                k++;
            }
            if (c < 0 || r < 0 || o < 0 || a < 0) {
                break;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) {
            return -1;
        }
        return res;
    }
}
