package 笔试.华为;

import java.util.Scanner;
import java.util.Stack;

/**
 * 找出最大的矩形面积   宽度和高度的取值为0-100   最多 20 个箱子
 * 输入：
 * [1,1,1,1,2,1,1],[5,2,5,4,5,1,6]    箱子的 宽度 和 高度
 * <p>
 * 输出：
 * 16
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length() - 1);
        String[] split = s.split("]" + ",\\[");
//        System.out.println(split[0]);
//        System.out.println(split[1]);
        String[] split1 = split[0].split("\\,");
        String[] split2 = split[1].split("\\,");
        if (split1.length != split2.length) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < split1.length; i++) {
            int num = Integer.parseInt(split1[i]);
            if (num <= 0) {
                System.out.println(0);
                return;
            }
        }
        for (int i = 0; i < split2.length; i++) {
            int num = Integer.parseInt(split2[i]);
            if (num <= 0) {
                System.out.println(0);
                return;
            }
        }
        int sum = 0;
        for (int i = 0; i < split1.length; i++) {
            int a = Integer.parseInt(split1[i]);
            sum += a;
        }
        int[] num = new int[sum];
        int j = 0;
        for (int i = 0; i < split1.length; i++) {
            int a = Integer.parseInt(split1[i]);
            int b = Integer.parseInt(split2[i]);
            while (a > 0) {
                num[j] = b;
                j++;
                a--;
            }
        }
        System.out.println(largestRectangleArea(num));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
