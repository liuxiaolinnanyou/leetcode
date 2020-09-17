package 笔试.欧科云链;

// 考察的是二分查找
public class Main {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        // write code here
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}