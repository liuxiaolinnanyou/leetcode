package vivo_2020;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 今年7月份vivo迎来了新入职的大学生，现在需要为每个新同事分配一个工号。人力资源部同事小v设计了一个方法为每个人进行排序并分配最终的工号，具体规则是：
 * 将N（N<10000）个人排成一排，从第1个人开始报数；如果报数是M的倍数就出列，报到队尾后则回到队头继续报，直到所有人都出列；
 * 最后按照出列顺序为每个人依次分配工号。请你使用自己擅长的编程语言帮助小v实现此方法。
 * <p>
 * 输入描述：输入2个正整数，空格分隔，第一个代表人数N，第二个代表M：
 * 输出描述：输出一个int数组，每个数据表示原来在队列中的位置用空格隔开，表示出列顺序：
 * <p>
 * 输入：6 3
 * 输出：3 6 4 2 5 1
 * 说明：6个人排成一排，原始位置编号即为1-6。最终输出3 6 4 2 5 1表示的是原来编号为3的第一个出列，编号为1的最后一个出列。
 */
public class 报数 {
    public static void main(String[] args) {
        int[] arr = {6, 3};
        System.out.println(solution(arr));
        System.out.println(solution2(arr));
    }

    // 方法 1
    public static String solution(int[] input) {
        int n = input[0];
        int m = input[1];
        int nums = 0;
        int end = n + 1;
        int[] stud = new int[n];     // 存储 1~n

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stud[i] = i + 1;
        }
        while (nums < n) {
            for (int i = 0; i < n; i++) {
                if (stud[i] > 0) {
                    if (stud[i] % m == 0) {
                        s.append(i + 1).append(" ");
                        nums++;
                        stud[i] = -1;
                    } else {
                        stud[i] = end++;
                    }
                }
            }
        }
        s.deleteCharAt(s.length() - 1);
        return s.toString();
    }


    // 方法 2
    // 抽到谁谁出列，删掉这个数，M的倍数==》每隔M-1个就抽一个，i从0开始抽，
    // 抽到最后一个接着从头开始算就是i=i%v.size();直到都抽完了就结束了。
    public static String solution2(int[] input) {
        int N = input[0];
        int M = input[1];
        if (N < 1 || M < 1) {
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }
        int i = 0;
        while (arr.size() > 0) {
            i += M - 1;
            if (i >= arr.size()) i = i % arr.size();
            sb.append(arr.get(i)).append(" ");
            arr.remove(i);
        }
        return sb.delete(sb.length() - 1, sb.length()).toString();
    }
}