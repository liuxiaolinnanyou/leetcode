package 注解与反射.反射;

public class Test04 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        /**
         * 1.加载到内存，会产生一个类对应Class对象
         * 2.链接，链接结束后 m = 0
         * 3.初始化
         *      <clinit>(){}
         */
    }
}

// 静态变量和静态代码块调换顺序结果会不同
class A {
    static int m = 100;

    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}