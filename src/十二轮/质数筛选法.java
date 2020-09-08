package 十二轮;

import java.util.Scanner;

/**
 * 具体做法是：先把N个自然数按次序排列起来。1不是质数，
 * 也不是合数，要划去。第二个数2是质数留下来，而把2后面所有能被2整除的数都划去。
 * 2后面第一个没划去的数是3，把3留下，再把3后面所有能被3整除的数都划去。
 * 3后面第一个没划去的数是5，把5留下，再把5后面所有能被5整除的数都划去。
 * 这样一直做下去，就会把不超过N的全部合数都筛掉，留下的就是不超过N的全部质数。
 */
// 质数判断的题   还可以参见京东笔试题和贝壳中的多益网络的面试题
public class 质数筛选法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] bs = new boolean[n];    // 不超过 n 的质数
        for (int i = 2; i < bs.length; i++) {
            for (int j = i + 1; j < bs.length; j++) {
                if (j % i == 0) {
                    bs[j] = true;
                }
            }
        }
        for (int i = 2; i < bs.length; i++) {
            if (bs[i] == false) {
                System.out.println(i);
            }
        }
    }
}