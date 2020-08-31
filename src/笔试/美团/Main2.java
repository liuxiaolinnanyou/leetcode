package 笔试.美团;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static class Car {
        int aP;
        int bP;
        int maxP;
        boolean wasted;

        public Car(int _a, int _b) {
            aP = _a;
            bP = _b;
            maxP = Math.max(aP, bP);
            wasted = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        Car[] carArr = new Car[n];
        for (int i = 0; i < n; i++) {
            int tmpA = sc.nextInt();
            int tmpB = sc.nextInt();
            carArr[i] = new Car(tmpA, tmpB);
        }
        Arrays.sort(carArr, (x, y) -> (y.maxP - x.maxP));
        int idx = 0;
        int res = 0;
        while (a > 0 && b > 0) {
            res += carArr[idx].maxP;
            carArr[idx].wasted = true;
            if (carArr[idx].maxP == carArr[idx].aP) {
                a--;
            } else {
                b--;
            }
            idx++;
        }
        idx = 0;
        if (a > 0) {
            Arrays.sort(carArr, (x, y) -> (y.aP - x.aP));
            while (a > 0) {
                if (!carArr[idx].wasted) {
                    res += carArr[idx].aP;
                    carArr[idx].wasted = true;
                    a--;
                }
                idx++;
            }
        } else if (b > 0) {
            Arrays.sort(carArr, (x, y) -> (y.bP - x.bP));
            while (b > 0) {
                if (!carArr[idx].wasted) {
                    res += carArr[idx].bP;
                    carArr[idx].wasted = true;
                    b--;
                }
                idx++;
            }
        }
        System.out.println(res);
    }
}
