package 华为;

import java.util.Scanner;

/**
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。
 * 百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * <p>
 * 输入描述:
 * 输入任何一个整数，即可运行程序。
 * <p>
 * 输入
 * 1
 * 输出
 * 0 25 75
 * 4 18 78
 * 8 11 81
 * 12 4 84
 */
public class Hw72_百钱买百鸡问题 {
    public static void main(String[] args) {
        // 3个for循环
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int n1 = 0;
            int n2 = 0;
            int n3 = 0;
            for (n1 = 0; n1 < 20; n1++) {
                for (n2 = 0; n2 < 33; n2++) {
                    for (n3 = 0; n3 < 100; n3 = n3 + 3) {
                        if (n1 + n2 + n3 == 100 && 5 * n1 + 3 * n2 + n3 / 3 == 100) {
                            System.out.println(n1 + " " + n2 + " " + n3);
                        }
                    }
                }
            }
        }
        sc.close();
    }
}