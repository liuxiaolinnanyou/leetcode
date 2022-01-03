package JavaGuide算法;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("JavaGuide算法.AnnotationTest");
        Method[] methods = clazz.getMethods();
        if (methods != null) {
            for (Method method : methods) {
                boolean isInitMethod = method.isAnnotationPresent(InitMethod.class);
                System.out.println(method.getName() + ":" + isInitMethod);
                if (isInitMethod) {
                    method.invoke(clazz.getConstructor(null).newInstance(null), null);
                }
            }
        }
    }
}