package 九轮;

import java.util.Arrays;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>
 * 输入: 4, 14, 2
 * 输出: 6
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * <p>
 * 注意:
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 */
public class 汉明距离总和 {
    public static void main(String[] args) {
        int[] arr = {4, 14, 2};
        System.out.println(totalHammingDistance(arr));
//        System.out.println("------------------------");
//        System.out.println(totalHammingDistance2(arr));
    }

    // 位运算
    // 求数组汉明距离，我们可以每次遍历数组的一位上有多少0和多少1，
    // 该位的汉明距离的和就是 0 的个数 × 1 的个数，因为 0 和 0 ，1 和 1 的汉明距离都是 0。然后遍历 32 位，全部加起来即可。

    // 这题可不可以将数组中的数转成对应的二进制字符串表示    然后统计二进制字符串中各个位上 1 的个数和 0 的个数
    public static int totalHammingDistance(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int len = nums.length;
        int[] sums = new int[32];
        for (int i = 0; i < len; i++) {           // 统计每个二进制位上的1出现个数
            for (int j = 0; j < 32; j++) {
                sums[j] += nums[i] & 1;           // 看是否是 1
                nums[i] = nums[i] >> 1;
                if (nums[i] == 0) {
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(sums));    // 逆序的表示
        int sum = 0;
        for (int i = 0; i < 32; i++) {          // 通过对每个二进制位上的1的个数和0的个数相乘，求和
            sum += sums[i] * (len - sums[i]);
        }
        return sum;
    }

    public static int totalHammingDistance2(int[] nums) {
        int len = nums.length;
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = Integer.toBinaryString(nums[i]);
        }
//        System.out.println(Arrays.toString(str));         // [100, 1110, 10]
        int maxLength = 0;
        for (int i = 0; i < len; i++) {
            maxLength = Math.max(maxLength, str[i].length());
        }
        int[] sum = new int[maxLength];
        for (int i = 0; i < len; i++) {   // 统计 1 的个数
            for (int j = 0; j < str[i].length(); j++) {
                if (str[i].charAt(j) == '1') {
                    sum[maxLength - str[i].length() + j]++;
                }
            }
        }
//        System.out.println(Arrays.toString(sum));
        int ans = 0;
        for (int i = 0; i < maxLength; i++) {
            ans += sum[i] * (len - sum[i]);
        }
        return ans;
    }
}
