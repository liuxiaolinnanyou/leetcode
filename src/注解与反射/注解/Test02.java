package 注解与反射.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation2(name = "刘晓林", schools = {"北京大学"})
public class Test02 {
    @MyAnnotation2(schools = {"南京邮电大学"})
    public void test() {

    }

    @MyAnnotation3("刘晓林")
    public void test2() {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数：参数类型 + 参数名()
    // 注解可以显式赋值，如果没有默认值，就必须给注解赋值
    String name() default "";

    int age() default 0;

    int id() default -1;  // 如果默认值为-1，代表不存在，参考indexOf

    String[] schools() default {"浙江大华"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    // 只有默认值为value时，可以省略
    String value();

//    String name();
}