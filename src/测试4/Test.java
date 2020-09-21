package 测试4;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
            for (String string : list) {
                list.remove(string);
            }
            System.out.println(list.size());
        }
    }
}