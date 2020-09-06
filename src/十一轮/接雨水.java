package 十一轮;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class 接雨水 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    // 每一个柱子的高度方向可以接的雨水的数量 = min(从当前柱子向左看的最高柱子高度, 从当前柱子向右看的最高柱子高度) - 当前柱子高度
    // 1）两个数组left、right分别保存：从左往右遍历时下标 i 最高柱子高度，和从右往左遍历时下标 i 最高柱子高度。
    // 2）再遍历一遍每个位置，只有当height[i]的高度，比left[i]和right[i]都要小的时候才能接住雨水（否则总有一边会漏，接不到雨水）
    // 3）将所有可以接到雨水的柱子的数量加起来
    public static int trap(int[] height) {
        int length = height.length;
        int[] left = new int[length];    // 保存从左往右遍历时，每一个下标位置当前的最高柱子高度
        int[] right = new int[length];   // 保存从右往左遍历时，每一个下标位置当前的最高柱子高度
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;

        // 计算 left 和 right 数组
        for (int i = 0; i < length; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            left[i] = leftMax;
            if (height[length - 1 - i] > rightMax) {
                rightMax = height[length - 1 - i];
            }
            right[length - 1 - i] = rightMax;
        }

        // 遍历，只有当前柱子往左看、往右看的最高柱子都比当前柱子高，才能接住雨水
        for (int j = 0; j < length; j++) {
            if (height[j] < left[j] && height[j] < right[j]) {
                sum = sum + Math.min(left[j], right[j]) - height[j];
            }
        }
        return sum;
    }

    // 单调栈就是比普通的栈多一个性质，即维护一个栈内元素单调
    // 比如当前某个单调递减的栈的元素从栈底到栈顶分别是：[10, 9, 8, 3, 2]，如果要入栈元素5，
    // 需要把栈顶元素pop出去，直到满足单调递减为止，即先变成[10, 9, 8]，再入栈5，就是[10, 9, 8, 5]。
    public static int trap2(int[] height) {
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    // stackTop此时指向的是此次接住的雨水的左边界的位置。右边界是当前的柱体，即i。
                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                    // i - stackTop - 1 是雨水的宽度。
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
