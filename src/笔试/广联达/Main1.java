package 笔试.广联达;

import java.util.*;

/**
 * 元素平衡
 * 魔法师体内地火水风四种元素平衡的时候才是绝对安全的，某魔法师给自己做了一个体检，发现体内的四种元素数量分别是A，B，C，D。
 * 可以把任意两个单位的元素转换成任意一种元素。请问魔法师是否可以通过这种魔法，在保证自己体内的元素总量尽可能多的情况下，
 * 使得自己体内的四种元素数量完全相同？如果可以，请输出平衡后体内元素总量，如果不能，请输出 -1。
 *
 * 输入仅包含一行，仅包含4个正整数A B C D，分别表示四种元素的数量。(1-10^7)
 * 输出仅包一个整数。
 *
 * 输入：1 2 2 4
 * 输出：8
 *
 * 只要把第四种元素中的两个转换为第一种元素即平衡。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] a = new long[4];
        for (int i = 0; i < 4; i++) {
            a[i] = sc.nextLong();
        }
        Arrays.sort(a);
        while (a[0] != a[1] || a[0] != a[1] || a[0] != a[3] || a[1] != a[2] || a[2] != a[3]) {
            if (a[3] - a[2] == 1) {
                a[3] -= 1;
                break;
            } else if (a[3] > a[2]) {
                a[3] -= 2;
                a[0] += 1;
            } else if (a[3] == a[2]) {
                a[3] -= 1;
                a[2] -= 1;
                a[0] += 1;
            }
            Arrays.sort(a);
        }
        System.out.println(a[0] * 4);
    }
}