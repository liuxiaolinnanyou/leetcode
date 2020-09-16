package 测试3;

class A {
    static {
        System.out.println("a");
    }

    public A() {
        System.out.println("b");
    }
}

class B extends A {
    static {
        System.out.println("c");
    }

    public B() {
        System.out.println("d");
    }
}

public class Test2 {
    public static void main(String[] args) {
        A b = new B();
        b = new B();              // 静态代码块只会执行一次   而构造方法在每次创建对象时都会调用
    }
}