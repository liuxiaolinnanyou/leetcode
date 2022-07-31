package 注解与反射.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 动态的创建对象，通过反射
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("注解与反射.反射.User");
        User user = (User) c1.newInstance();   // 本质是调用了类的无参构造器
        System.out.println(user);

        // 通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User lxl = (User) constructor.newInstance("lxl", 1, 18);
        System.out.println(lxl);

        // 通过反射调用普通方法
        User user1 = (User) c1.newInstance();
        // 通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user1, "刘晓林");
        System.out.println(user1.getName());


        // 通过反射操作属性
        User user2 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user2, "刘晓林2");
        // Class 注解与反射.反射.Test07 can not access a member of class 注解与反射.反射.User with modifiers "private"
        System.out.println(user2.getName());
    }
}