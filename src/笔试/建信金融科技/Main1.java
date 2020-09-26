package 笔试.建信金融科技;

// 这题其实是一个数组只有一个元素出现一次，其余元素都出现了两次，找出那个只出现一次的元素。
public class Main1 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 8, 9, 1, 1, 9, 8};
        System.out.println(uniqueAward(arr));
    }

    public static int uniqueAward(int[] nums) {
        // write code here
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}