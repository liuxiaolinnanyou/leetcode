package 快手;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给定一个32位int型正整数，我们定义如下操作，取其十进制各位数字的平方和，并不断重复这个操作。
 * 如果某次操作完成后得到的结果是1，则返回true；否则继续执行，直到证明永远不会得到结果为1，返回false
 * input:19
 * output:true
 * 原因：
 * 1^2 + 9^2=82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 =  100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * 输入描述：
 * 输入一个m(1<=m<=1000)，表示查询组数。
 * 接下来m行，每一行为一个32位int型正整数。
 * 输出描述：
 * 对于每次查询，如果满足题目描述，则输出"true"，反之输出"false" (不要输出引号)
 * <p>
 * 输入：
 * 2
 * 19
 * 7
 * 输出：
 * true
 * true
 */
public class 计算累计平方和 {
    public static void main(String[] args) {
        // 建立一个二维数组,提高后面平方的运算速度
        int[][] lib = new int[10][2];
        for (int i = 0; i < 10; i++) {
            lib[i][0] = i;
            lib[i][1] = i * i;
        }
        // 读取数据
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            System.out.println(isOne(arr[i], lib, list));
        }


        // 方法 2 测试
//        // 必须要用快慢指针，不然会超时的
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        for (int i = 0; i < m; i++) {
//            int num = sc.nextInt();
//            int slow = num;
//            int fast = getNext(num);
//            while (slow != fast && fast != 1) {
//                slow = getNext(slow);
//                fast = getNext(getNext(fast));
//            }
//            System.out.println(fast == 1 ? "true" : "false");
//        }
    }

    public static boolean isOne(int num, int[][] lib, List<Integer> list) {
        if (num == 1) {
            return true;
        }
        // 这里最重要的就是判断什么时候是false,其实就是循环了
        // 每次判断 list 中是否已经含有当前数字,如果有,那就不可能为 1 了;
        if (list.contains(num)) {
            return false;
        }
        // 并且插入num
        list.add(num);
        int n = 0;
        while (num > 0) {
            int tmp = num % 10;
            n += lib[tmp][1];
            num /= 10;
        }
        return isOne(n, lib, list);
    }


    public static int getNext(int num) {
        int res = 0;
        while (num > 0) {
            int temp = num % 10;
            res += temp * temp;
            num /= 10;
        }
        return res;
    }
}
