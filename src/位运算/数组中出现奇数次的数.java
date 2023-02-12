package 位运算;

/**
 * 1.一个数组中只有一个数出现了奇数次，其余数都出现了偶数次，找出这个出现了奇数次的数。
 * 2.一个数组中只有两个数出现了奇数次，其余数都出现了偶数次，找出这两个出现了奇数次的数。
 */
public class 数组中出现奇数次的数 {
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0, onlyOne = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        // eor = a ^ b
        // eor != 0
        // eor 必然有一个位置上是1
        // 提取出最右的1
        int rightOne = eor & (~eor + 1);
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {   // 写0 写1 都一样
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}