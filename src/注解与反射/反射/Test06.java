package 注解与反射.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> c1 = Class.forName("注解与反射.反射.User");

        // 获得类的名字
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        // 获得类的属性
        System.out.println("----------------------------");
        Field[] fields = c1.getFields();    // public属性
        for (Field field : fields) {
            System.out.println(field);
        }

        Field[] declaredFields = c1.getDeclaredFields();   // 全部的属性
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        // 获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        // 获得类的方法
        System.out.println("====================================");
        Method[] methods = c1.getMethods();   // 本类及其父类的全部public方法
        for (Method method : methods) {
            System.out.println("正常的：" + method);
        }

        methods = c1.getDeclaredMethods();     // 本类的所有方法(包括私有)
        for (Method method : methods) {
            System.out.println("getDeclareMethods:" + method);
        }

        // 获取指定方法
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        // 获得指定的构造器
        Constructor[] constructors = c1.getConstructors();
        Constructor[] declaredConstructors = c1.getDeclaredConstructors();

        // 获得指定的构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定：" + declaredConstructor);
    }
}