package LeetCode_二分查找;

/**
 * https://www.cnblogs.com/hzyuan/p/15760769.html
 * 1）数组第一个元素比第二个元素小，即为局部最小值。
 * 2）数组最后一个元素比它前一个元素小，即为局部最小值。
 * 3）若不满足，那么局部最小值必可在数组首尾两元素之间的某个位置取得。此时可以采用二分法思想，看中间位置是否符合条件，不符合就分成两部分，从不符合的那一边继续操作。
 */
public class 局部最小值 {
    public static int findLM(int[] arr) {
        if (arr == null || arr.length == 0) { //数组为空或数据长度为0
            return -1;
        }
        if (arr.length == 1) { //数组只有一个元素即为局部最小值
            return 0;
        }
        if (arr[0] < arr[1]) { //数组第一个元素比第二个元素小，即为局部最小值
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {//数组最后一个元素比它前一个元素小，即为局部最小值
            return arr.length - 1;
        }
        // 上述条件均不满足，局部最小值必在数组内部取得
        // 用二分法思想求解
        int left = 0, right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 测试
        int[] arr = {4, 3, 6, 8, 2, 1, 5, 7};
        int res = findLM(arr);
        if (res < 0) {
            System.out.println("最小值不存在");
        } else {
            System.out.println(arr[res]);
        }
    }
}
