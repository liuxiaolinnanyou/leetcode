package 华为;

import java.util.Scanner;

/**
 * 根据输入的日期，计算是这一年的第几天。
 * 详细描述：
 * 输入某年某月某日，判断这一天是这一年的第几天？
 * <p>
 * 输入描述:
 * 输入三行，分别是年，月，日
 * 输出描述:
 * 成功:返回outDay输出计算后的第几天;
 * 失败:返回-1
 * <p>
 * 输入
 * 2012
 * 12
 * 31
 * 输出
 * 366
 */
public class Hw73_计算日期到天数转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(converDateToDay(year, month, day));
        }
    }

    public static int converDateToDay(int year, int month, int day) {
        int[] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {       // 判断闰年
            Day[1] = 29;
        }
        if (year <= 0 || month <= 0 || month > 12 || day <= 0 || day > Day[month - 1]) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += Day[i];
        }
        return sum + day;
    }
}