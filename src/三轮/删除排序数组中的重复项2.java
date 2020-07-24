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

    // 与删除排序数组中的重复项问题的区别是，可以重复两个
    // 增加一个重复个数的状态repeatNum
    // 当快指针指向的是和慢指针相同的元素，用repeatNum判断
    public static int removeDuplicates2(int[] nums) {
        int show = 0;
        // 增加一个重复个数的状态
        int repeatNum = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[show]) {
                nums[++show] = nums[fast];
                // 计数清除
                repeatNum = 1;
            } else {
                // 如果重复次数小于2次，还可以移动
                if (repeatNum < 2) {
                    // 如果快指针和慢指针不是挨着，就需要赋值
                    nums[++show] = nums[fast];
                    // 重复次数增加
                    repeatNum++;
                }
            }
        }
        return show + 1;
    }
}