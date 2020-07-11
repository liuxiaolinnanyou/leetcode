package 快手;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 合并两个内容流，实现隔4个插入1个，如果合并完还有剩下，则加内容流尾部
 * <p>
 * 输入描述：
 * 第1行表示第一种类型的内容，字符数量<=100，空格分隔。比如说
 * 1 2 3 4 5 6 7 8 9
 * a b c
 * 输出描述：
 * 合并两种内容流，输出
 * 1 2 3 4 a 5 6 7 8 b 9 c
 * <p>
 * 输入1：
 * 1 2 3 4 5 6 7 8 9
 * a b c
 * 输出1：
 * 1 2 3 4 a 5 6 7 8 b 9 c
 */
public class 合并内容流 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        List<String> list = doInsert(s1.trim().split(" "), s2.trim().split(" "));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static List<String> doInsert(String[] str1, String[] str2) {
        List<String> list = new ArrayList<>();
        int j = 0;
        int count = 0;
        for (int i = 0; i < str1.length; i++) {
            list.add(str1[i]);
            count++;
            if (count == 4 && j < str2.length) {
                count = 0;
                list.add(str2[j]);
                j++;
            }
        }
        while (j < str2.length) {
            list.add(str2[j++]);
        }
        return list;
    }
}