package 十轮;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * <p>
 * 注意: 输入数组的长度不会超过 10000。
 */
public class 下一个更大元素2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
        System.out.println(Arrays.toString(nextGreaterElements2(arr)));
    }

    // 首先需要解决的问题是，如何实现循环数组，即“最后一个元素的下一个元素是数组的第一个元素”。
    // 事实上，我们只要能遍历两遍数组，效果就等同于循环。虽然创建一个长度为原数组二倍的数组也可以，
    // 但为了额外空间尽可能少，这里采用取模的方式，将索引限制在小于数组长度的正整数范围内。见代码中注释。

    // 维护一个单调栈，由栈顶至栈底由小到大。
    //（1）当遍历到数组的一个新的元素时，若栈顶比该元素小，那么对此时的栈顶来说，找到了下一个更大元素，
    // 便从栈中弹出。继续判断栈顶是否小于该元素，小于则弹出，直到栈为空或栈顶大于该元素。
    //（2）当栈为空或栈顶大于该元素时，直接将该元素入栈。
    //
    // 由于本题中未规定数组中元素无重复，所以为了唯一识别一个元素，栈中需要保存数组的索引，而不是数组元素的值。
    // 时间复杂度 O(N)，空间复杂度O(N)
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;                     // 不存在，置 -1
        }
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            int index = i % nums.length;      // 取模，实现循环数组
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {   // 找到下一个更大元素
                res[stack.pop()] = nums[index];      // 栈中保存的是索引
            }
            stack.push(index);
        }
        return res;
    }

    // 暴力
    // 对于每一个元素，都向后进行nums.length长度的遍历。
    // 如果向后的下标超过了数组的长度，则对下标进行取模，
    // 这样每一个元素就都能都在题目中所叙的循环数组中找到是否有最大的下一个元素。
    public static int[] nextGreaterElements2(int[] nums) {
        // 构建用于记录结果的数组，初始化为 -1
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            // 对于每一个元素 i，向后遍历 num.lenght 长度
            int count = 0;
            int j = i + 1;
            while (count < nums.length) {
                // 对下标进行取模操作
                j = j % nums.length;
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
                j++;
                count++;
            }
        }
        return res;
    }
}
