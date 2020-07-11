package 牛客;


import java.util.Scanner;

/**
 * 数列 {An} 为N的一种排列。
 * 例如N=3，可能的排列共6种：
 * 1, 2, 3
 * 1, 3, 2
 * 2, 1, 3
 * 2, 3, 1
 * 3, 1, 2
 * 3, 2, 1
 * <p>
 * 定义函数F:
 * f(x)=A1 x=1    f(x)=|f(x-1)-Ax| x>1
 * 其中|X|表示X的绝对值。
 * 现在多多鸡想知道，在所有可能的数列 {An} 中，F(N)的最小值和最大值分别是多少。
 * <p>
 * 输入描述：
 * 第一行输入1个整数T，表示测试用例的组数。
 * ( 1 <= T <= 10 )
 * 第二行开始，共T行，每行包含1个整数N，表示数列 {An} 的元素个数。
 * ( 1 <= N <= 100,000 )
 * 输出描述：
 * 共T行，每行2个整数，分别表示F(N)最小值和最大值
 * <p>
 * 输入：
 * 2
 * 2
 * 3
 * 输出：
 * 1 1
 * 0 2
 * 说明：
 * 对于N=3：
 * - 当{An}为3，2，1时可以得到F(N)的最小值0
 * - 当{An}为2，1，3时可以得到F(N)的最大值2
 */
public class 拼多多_多多的排列函数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        for (int i = 0; i < nums; i++) {
            int N = sc.nextInt();
            maxandmin(N);
        }
    }

    public static void maxandmin(int N) {
        if (N == 1 || N == 2) {
            System.out.println("1 1");
            return;
        }
        // 之后每4个一组 0011
        int min = getmin(N);
        int max = N - getmin(N - 1);
        System.out.println(min + " " + max);
    }

    public static int getmin(int N) {
        int temp = (N - 2) % 4;
        if (temp == 1 || temp == 2) {
            return 0;
        } else {
            return 1;
        }
    }
}
