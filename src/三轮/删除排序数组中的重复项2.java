package 三轮;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class 删除排序数组中的重复项2 {
    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 1.指针定义 [0,index] 是修改后无重复的排序元素 注意 这里已经把 0 纳入进去了
        int index = 0;
        // 2.另一个循环指针 从1开始，终止为nums.length，为什么从1开始 因为我们要比较重复 nums[0] 肯定是不重复的
        for (int i = 1; i < nums.length; i++) {
            // 3.指针运动的条件
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        // 4.根据定义确定返回值
        return index + 1;
    }
}
