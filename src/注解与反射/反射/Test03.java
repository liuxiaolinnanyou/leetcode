package 注解与反射.反射;

import java.lang.annotation.ElementType;

/**
 * 所有类型的Class
 */
public class Test03 {
    public static void main(String[] args) {
        // 类
        Class<Object> c1 = Object.class;
        // 接口
        Class<Comparable> c2 = Comparable.class;
        // 一维数组
        Class<String[]> c3 = String[].class;
        // 二维数组
        Class<int[][]> c4 = int[][].class;
        // 注解
        Class<Override> c5 = Override.class;
        // 枚举
        Class<ElementType> c6 = ElementType.class;
        // 基本类型的包装类
        Class<Integer> c7 = Integer.class;
        // void
        Class<Void> c8 = void.class;
        // Class
        Class<Class> c9 = Class.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        // 一个类只有一个Class对象
        // 只要元素类型与维度一样，就是同一个Class
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}