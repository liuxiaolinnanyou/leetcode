package 注解和反射;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义注解
public class Test {
    // 注解可以显示赋值   如果没有默认值我们就必须给注解赋值
    @MyAnnotation(name = "刘晓林", schools = {"南京邮电大学"})
    public void test() {
    }

    @MyAnnotation1("liu")
    public void test1() {
    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    // 注解的参数   参数类型 + 参数名 ();
    String name() default "";

    int age() default 0;

    int id() default -1;    // 如果默认值为 -1 代表不存在，indexOf，如果找不到就返回 -1.

    String[] schools() default {"西部开源", "南京邮电大学"};
}


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
    String value();
}