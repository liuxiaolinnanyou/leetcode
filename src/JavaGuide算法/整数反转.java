package JavaGuide算法;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class 整数反转 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println("---------------------------------");
        System.out.println(reverse2(123));
        System.out.println(reverse2(-123));
        System.out.println(reverse2(120));
        System.out.println("---------------------------------");
        System.out.println(reverse3(123));
        System.out.println(reverse3(-123));
        System.out.println(reverse3(120));
    }

    // 方法 1
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            int newRes = res * 10 + temp;
            // 如果数字溢出，直接返回 0
            if ((newRes - temp) / 10 != res) {
                return 0;
            }
            res = newRes;
            x = x / 10;
        }
        return res;
    }

    // 方法 2       掌握
    public static int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }


    // 方法 3    String    掌握
    public static int reverse3(int x) {
        String a = Integer.toString(x);
        int b = 1;     // 处理符号位
        if (a.charAt(0) == '-') {
            a = a.substring(1);     // 截取符号位之后的
            b = -1;
        }
        char[] chars = a.toCharArray();
        char[] chars1 = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            chars1[chars.length - 1 - i] = chars[i];
        }
        Long aLong = Long.valueOf(new String(chars1));
        if (aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (aLong * b);
    }
}