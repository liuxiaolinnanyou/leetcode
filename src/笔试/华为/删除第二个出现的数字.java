package 笔试.华为;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 删除第二个出现的数字 {
    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 0, 2, 1, 5};
        System.out.println(seqFilter(input));
    }

    public static String seqFilter(int[] input) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (m.keySet().contains(input[i])) {
                if (m.get(input[i]) != 1) {
                    list.add(input[i]);
                }
                m.put(input[i], m.get(input[i]) + 1);
            } else {
                list.add(input[i]);
                m.put(input[i], 1);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i : list) {
            sb.append(i + " ");
        }
        return sb.toString();
    }
}