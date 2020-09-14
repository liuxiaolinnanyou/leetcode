package 笔试.五八同城;

import java.io.FileReader;
import java.util.Arrays;

/**
 * 一个未排序的整数数组，请找出其中没有出现的最小的正整数。
 * 输入：[1,-1,2,5,4]
 * 输出：3
 */
public class Main2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, -1, 2, 5, 4};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        // write code here
        int l = 0;
        int r = nums.length;
        while (l < r) {
            if (nums[l] == l + 1) {
                l++;
            } else if (nums[l] < l + 1 || nums[l] > r || nums[nums[l] - 1] == nums[l]) {
                r--;
                nums[l] = nums[r];
            } else {
                swap(nums, l, nums[l] - 1);
            }
        }
        return l + 1;
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
