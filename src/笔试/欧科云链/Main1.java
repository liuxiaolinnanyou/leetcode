package 笔试.欧科云链;

// 2 的幂

/**
 * 1.统计该数的二进制中 1 的个数，如果个数为 1 就是，否则就不是。
 * 2.x&(x-1)==0
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo2(2));
        System.out.println("-----------------");
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo2(8));
        System.out.println("-----------------");

        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo2(15));
    }

    public static boolean isPowerOfTwo(int n) {
        // write code here
        String string = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                count++;
            }
        }
        return count == 1 ? true : false;
    }

    public static boolean isPowerOfTwo2(int n) {
        // write code here
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count == 1 ? true : false;
    }
}