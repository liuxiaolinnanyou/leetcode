package 笔试.达达集团;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 0) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split(",");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            for (int j = 0; j < b; j++) {
                list.add(a);
            }
        }
        for (int i = 1; i <= 100000; i++) {
            Random random = new Random();
            int num = random.nextInt(list.size());
            System.out.println(list.get(num));
        }
    }
}