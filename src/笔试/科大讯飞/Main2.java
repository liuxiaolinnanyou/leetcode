package 笔试.科大讯飞;

import java.util.Scanner;

/**
 * 统计二进制中 1 的个数。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            System.out.println(solution(n));
        }
    }

    public static int solution(long num) {
        int count = 0;
        while (num != 0) {
            count++;
            num &= (num - 1);
        }
        return count;
    }
}