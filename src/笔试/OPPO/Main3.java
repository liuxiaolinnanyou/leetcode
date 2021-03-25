package 笔试.OPPO;

// 给定一个十进制整数，求它在九进制下的表示。
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(convertToBase9(num));
    }

    public static String convertToBase9(int num) {
        // write code here
        return Integer.toString(num, 9);
    }
}
