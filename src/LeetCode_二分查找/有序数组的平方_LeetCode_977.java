package LeetCode_二分查找;

import java.util.Arrays;

public class 有序数组的平方_LeetCode_977 {
    // [-5, 1, 2, 3]
    // 双指针
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-5, 1, 2, 3};
        int[] arr1 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(arr)));
        System.out.println(Arrays.toString(sortedSquares(arr1)));
    }
}