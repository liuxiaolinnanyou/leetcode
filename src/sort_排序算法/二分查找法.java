package sort_排序算法;

public class 二分查找法 {
    public static void main(String[] args) {
        int[] arr = {1, 6, 15, 18, 27, 50};
        int findValue = 27;
        int binaryResult = binarySearch(arr, 0, arr.length - 1, findValue);
        System.out.println("元素第一次出现的位置（从0开始）：" + binaryResult);
    }

    public static int binarySearch(int[] nums, int start, int end, int findValue) {
        if (start <= end) {
            // 中间位置
            int middle = (start + end) / 2;
            // 中间的值
            int middleValue = nums[middle];
            if (findValue == middleValue) {
                // 等于中值直接返回
                return middle;
            } else if (findValue < middleValue) {
                // 小于中值，在中值之前的数据中查找
                return binarySearch(nums, start, middle - 1, findValue);
            } else {
                // 大于中值，在中值之后的数据中查找
                return binarySearch(nums, middle + 1, end, findValue);
            }
        }
        return -1;
    }
}