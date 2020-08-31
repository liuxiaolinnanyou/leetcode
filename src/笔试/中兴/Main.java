package 笔试.中兴;

import java.util.Scanner;

/**
 * 逆序对数
 * <p>
 * 输入：
 * 3
 * 1 2 4
 * 3 5 6
 * 输出：
 * 1
 */

// 自己写的   AC 60
public class Main {
//    public int result = 0;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        String s1 = sc.nextLine();
//        String s2 = sc.nextLine();
//        String[] split1 = s1.split(" ");
//        String[] split2 = s2.split(" ");
//        int[] arr1 = new int[n];
//        int[] arr2 = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr1[i] = Integer.parseInt(split1[i]);
//            arr2[i] = Integer.parseInt(split2[i]);
//        }
//        int[] arr = new int[2 * n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = arr1[i];
//            arr[n + i] = arr2[i];
//        }
//        Main m = new Main();
//        int res = m.reversePairs(arr);
//        System.out.println(res);
//    }
//
//    public int reversePairs(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        mergeCount(nums, 0, nums.length - 1);
//        return result;
//    }
//
//    public void mergeCount(int[] nums, int left, int right) {
//        if (nums.length < 2 || nums == null || left == right) {
//            return;
//        }
//        int mid = left + (right - left) / 2;
//        mergeCount(nums, left, mid);
//        mergeCount(nums, mid + 1, right);
//        merge(nums, left, mid, right);
//    }
//
//    public void merge(int[] nums, int left, int mid, int right) {
//        int[] help = new int[right - left + 1];
//        int p = help.length - 1;
//        int temp = mid + 1;
//        while (mid >= left && right >= temp) {
//            result = nums[mid] > nums[right] ? result + right - temp + 1 : result;
//            help[p--] = nums[mid] > nums[right] ? nums[mid--] : nums[right--];
//        }
//        while (mid >= left) {
//            help[p--] = nums[mid--];
//        }
//        while (right >= temp) {
//            help[p--] = nums[right--];
//        }
//        for (int i = 0; i < help.length; i++) {
//            nums[left + i] = help[i];
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(a(nums, 0, nums.length - 1));
    }

    private static int a(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = a(nums, start, mid) + a(nums, mid + 1, end);

        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += nums[i] <= nums[j] ? j - mid - 1 : 0;
            tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            count += (j - mid - 1);
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }
        System.arraycopy(tmp, 0, nums, start, end - start + 1);
        return count;
    }
}