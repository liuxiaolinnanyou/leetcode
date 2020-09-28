package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class teacherClass = Class.forName("反射.Teacher");
            Constructor constructor = teacherClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | ClassNotFoundException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}