package 笔试.声网;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 给定一个整数 n ，0 < n < 10000 且 n 不能被 2 或者 5 整除，那么一定存在一个整数 m ，m = c * n (c为整数且c >= 1)
 * 且 m 的十进制表示中每一位都由 1 组成，求解其中值最小的 m 的位数。
 * <p>
 * 输入：一个整数 n
 * 输出：m 的位数
 * <p>
 * 输入：3
 * 输出：3
 * 说明：当 n = 3 时，满足条件的 m 值为 111 位数为 3.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger x = new BigInteger("1");
        BigInteger ten = new BigInteger("10");
        BigInteger one = new BigInteger("1");
        int res = 1;
        while (!x.mod(new BigInteger(Integer.toString(n))).equals(new BigInteger("0"))) {
            x = x.multiply(ten);
            x = x.add(one);
            res++;
        }
        System.out.println(res);
    }
}