package 笔试.海康威视;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int type = sc.nextInt();
//        System.out.println(calc(a, b, type));
        System.out.println(calc(1, 2, 0));
        System.out.println(calc(1, 2, -1));
        System.out.println(calc(1, 2, 1));
    }

    public static int calc(int a, int b, int type) {
        int res = 0;
        if (type == 1) {
            // 乘法
            for (int i = 0; i < b; i++) {
                res = res + a;
            }
        } else if (type == -1) {
            // 减法
            res = a + (~b) + 1;
        } else {
            // 除法
            int temp = a;
            while (temp > 0 && temp >= b) {
                temp = temp + (~b) + 1;
                res++;
            }
        }
        return res;
    }
}