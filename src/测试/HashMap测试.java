package 测试;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap测试 {
    public static void test1() {
        System.out.println("使用用户自定义类型作为键：");
        HashMap<String, String> hm = new HashMap<>();
        hm.put("aaa", "bbb");
        hm.put("aaa", "ccc");
        hm.put("ccc", "ccc");

        Iterator<Map.Entry<String, String>> iterator = hm.entrySet().iterator();
//        Set<Map.Entry<String, String>> entrySet = hm.entrySet();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "        " + value);
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
