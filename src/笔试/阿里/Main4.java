package 笔试.阿里;

import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        int[] arr = new int[]{};
        Integer a = Arrays.stream(arr).reduce(Integer::sum).orElseGet(null);
        System.out.println(a);
    }
}
