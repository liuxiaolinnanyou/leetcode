package 注解与反射.注解;

import java.lang.annotation.*;

/**
 * 测试元注解
 */
public class Test01 {
    @MyAnnotation
    public void test() {

    }
}


// 定义一个注解
/**
 * 1.@interface 用来声明一个注解，格式：public @interface 注解名{定义内容}
 * 2.其中的每一个方法实际上是声明了一个配置参数
 * 3.方法的名称就是参数的名称
 * 4.返回值类型就是参数的类型（返回值只能是基本类型，Class，String，Enum）
 * 5.可以通过default来声明参数的默认值
 * 6.如果只有一个参数成员，一般参数名为value
 * 7.注解元素必须要有值，我们定义注解元素时，经常使用空字符串，0作为默认值
 */
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation {

}

