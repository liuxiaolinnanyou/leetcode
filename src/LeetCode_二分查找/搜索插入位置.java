package LeetCode_二分查找;

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
输入: [1,3,5,6], 5
输出: 2

输入: [1,3,5,6], 2
输出: 1

输入: [1,3,5,6], 7
输出: 4

输入: [1,3,5,6], 0
输出: 0
 */
public class 搜索插入位置 {
    /*
    如果该题目暴力解决的话需要 O(n) 的时间复杂度，但是如果二分的话则可以降低到 O(logn) 的时间复杂度
    整体思路和普通的二分查找几乎没有区别，先设定左侧下标 left 和右侧下标 right，再计算中间下标 mid
     */
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int result = searchInsert2(arr, 5);
        int result2 = searchInsert2(arr, 2);
        int result3 = searchInsert2(arr, 7);
        int result4 = searchInsert2(arr, 0);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }


    // 方法 1
    public static int searchInsert(int[] nums, int target) {
        // 简单的二分查找
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 小知识点： java数组的最大长度为 int 的最大值
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 此时left = right
        return target <= nums[left] ? left : left + 1;
    }


    // 方法 2
    public static int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
