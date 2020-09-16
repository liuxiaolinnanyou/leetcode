package 测试3;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Short> s = new HashSet<>();
        for (short i = 0; i < 100; i++) {
            s.add(i);
            s.remove(i - 1);            // 这边注意：set 集合中添加的元素是 Short 类型的    而移出的是 int 类型的
                                           // 如果改成 i      set 集合的长度就会变成 0
        }
        System.out.println(s.size());
        System.out.println(s);

//        Set<Short> set = new HashSet<>();
//        set.add((short)1);
//        set.remove((short) 1);
//        System.out.println(set);
    }
}