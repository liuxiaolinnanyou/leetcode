package JavaGuide算法;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能)，但是string不符合数字要求时返回 0 。
 * 要求不能使用字符串转换整数的库函数。数值为 0 或者字符串不是一个合法的数值则返回 0 。
 */
public class 把字符串转换成整数 {
    public static void main(String[] args) {
        String s = "-12312312";
        String ss = "1256";
        System.out.println(Integer.valueOf(s));
        System.out.println(strToInt(s));
        System.out.println("-----------------------------------");
        System.out.println(Integer.valueOf(ss));
        System.out.println(strToInt(ss));
    }

    // 将字符串转成整数
    public static int strToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();       // 字符串转成字符数组
        // 判断是否存在符号位
        int flag = 0;
        if (chars[0] == '+') {
            flag = 1;
        } else if (chars[0] == '-') {
            flag = 2;                            // 负数
        }
        int start = flag > 0 ? 1 : 0;            // 没有符号位就从 0 开始，有符号位就从 1 开始。
        int res = 0;                             // 保存结果
        for (int i = start; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {   // 判断是否是数字，是返回true，否则false
                int temp = chars[i] - '0';
                res = res * 10 + temp;
            } else {
                return 0;
            }
        }
        return flag != 2 ? res : -res;
    }
}
