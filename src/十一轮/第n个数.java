package 十一轮;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 自从学了素数以后，小明喜欢上了数字 2 , 3 , 5。当然，如果一个数字里面只含有 2 , 3 , 5这三个数字，
 * 他也一样喜欢，例如：222、2355、223355
 * 现在他希望你能够帮他编写一个程序，快速计算出由 2 , 3 , 5这三个数字组成的由小到大的第 n 个数，当然也包括 2 , 3 , 5。
 */
public class 第n个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        queue.add("2");
        queue.add("3");
        queue.add("5");

        int t = 0;
        int n = sc.nextInt();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                t++;
                if (n == t) {
                    System.out.println(s);
                    return;
                }
                queue.add(s + "2");
                queue.add(s + "3");
                queue.add(s + "5");
            }
        }
    }
}