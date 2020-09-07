package 笔试.贝壳;

/**
 * 多益网络面试题
 * 求1000以内的所有质数，并且各位数字之和是偶数
 */
public class Main2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            if (isPrime(i) && isEven(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isEven(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        if (num == 1) {
            return false;
        }
        return true;
    }
}