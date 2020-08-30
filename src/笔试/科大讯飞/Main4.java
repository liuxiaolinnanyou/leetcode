package 笔试.科大讯飞;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 字符串前后所有以及中间多于一个的下划线被称为“多余的下划线”，编程在原串上进行去除多余下划线操作。
 * <p>
 * 输入：___abs__sadhjk_sdnjk___
 * 输出：abs_sadhjk_sdnjk
 */
public class Main4 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] split = s.split("_+");
//        StringBuilder sb = new StringBuilder();
//        for (String str : split) {
//            sb.append(str).append("_");   // 当以下划线开头时，默认前面会有一个空字符串，因此这样会造成以 _ 开头
//        }
//        String res = sb.deleteCharAt(sb.length() - 1).toString();
//        if (res.startsWith("_")) {
//            System.out.println(res.substring(1));
//        } else {
//            System.out.println(res);
//        }


        // 用递归实现二分查找
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int num = sc.nextInt();
        String[] split = s.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(recursiveFind(arr, 0, n - 1, num));

//        ArrayList<String> l1 = new ArrayList<>();
//        ArrayList<? extends String> l2 = new ArrayList<>();
//        ArrayList<Integer> l3 = new ArrayList<>();
//        Class c1 = l1.getClass();
//        Class c2 = l2.getClass();
//        Class c3 = l3.getClass();
//        System.out.println(c1 == c2);
//        System.out.println(c1 == c3);
//
//        System.out.println("12".compareTo("13"));
    }

    private static int recursiveFind(int[] arr, int start, int end, int searchKey) {
        if (start <= end) {
            int middle = (start + end) / 2;
            if (searchKey == arr[middle]) {
                return middle;
            } else if (searchKey < arr[middle]) {
                return recursiveFind(arr, start, middle - 1, searchKey);
            } else {
                return recursiveFind(arr, middle + 1, end, searchKey);
            }
        } else {
            return -1;
        }
    }
}