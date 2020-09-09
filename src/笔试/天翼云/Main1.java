package 笔试.天翼云;

/**
 * 设 a , b , c , d 均是 0 到 9 之间的数字，abcd , bcda 是两个四位数，且有 abcd + bcda = 8888。
 * 求满足条件的所有 a , b , c , d的值。按照 a 从小到大的顺序输出。
 */
public class Main1 {
    public static void main(String[] args) {
        for (int a = 0; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 0; d <= 9; d++) {
                        if ((a + b == 8) && (b + c == 8) && (c + d == 8) && (d + a == 8)) {
                            System.out.println(a + " " + b + " " + c + " " + d);
                        }
                    }
                }
            }
        }
    }
}
