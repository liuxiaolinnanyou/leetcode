package 笔试.最右;

import java.util.Scanner;

// 36进制转10进制
// AC 80
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

    public static long solution(String s) {
        return Long.valueOf(s, 36);
    }
}
