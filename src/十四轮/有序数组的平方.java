package 十四轮;
// 力扣 977

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 说明：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * <p>
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class 有序数组的平方 {
    public static void main(String[] args) {
        int[] arr1 = {-4, -1, 0, 3, 10};
        int[] arr2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(arr1)));
        System.out.println(Arrays.toString(sortedSquares(arr2)));
    }

    // 双指针
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int len = nums.length;
        int right = len - 1;
        int index = len - 1;
        int[] res = new int[len];
        while (index >= 0) {
            // 判断哪个元素的绝对值大          通过相加判断正负有问题  若全是负数就无法通过
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[index--] = nums[left] * nums[left];
                left++;
            } else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}