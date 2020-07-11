package 设计模式.单例模式;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 接口的默认方法
 * lambda表达式   lambda表达式允许把函数作为一个方法的参数
 */
public class Jdk8 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names);
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
//                return b.compareTo(a);
                return a.compareTo(b);
            }
        });
        System.out.println(names);

        System.out.println("-------------------------------------------");

        /**
         * 只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。
         * 通常做法都是创建一个匿名的比较器对象然后将其传递给sort方法。
         * 在Java 8 中你就没必要使用这种传统的匿名对象的方式了，
         * Java 8提供了更简洁的语法，lambda表达式。
         */
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        /**
         * 对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字，
         * 但是你还可以写得更短点,Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型。
         */
        Collections.sort(names, (a, b) -> b.compareTo(a));

    }
}
