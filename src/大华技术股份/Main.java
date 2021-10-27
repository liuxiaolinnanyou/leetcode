package 大华技术股份;

import java.util.Arrays;

/**
 * 力扣 179.最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class Main {
    public static void main(String[] args) {
        int[] arr1 = {10, 2};
        int[] arr2 = {3, 30, 34, 5, 9};
        int[] arr3 = {1};
        int[] arr4 = {10};
        System.out.println(largestNumber(arr1));
        System.out.println(largestNumber(arr2));
        System.out.println(largestNumber(arr3));
        System.out.println(largestNumber(arr4));
    }

    public static String largestNumber(int[] nums) {
        int len = nums.length;
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }
//        Arrays.sort(str);       这样写 [3,30,34,5,9]   输出结果为9534303
        Arrays.sort(str, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        // 如果排序后的第一个元素是0，那后面的元素肯定小于或等于0，则可直接返回0
        if (str[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append(str[i]);
        }
        return res.toString();
    }
}