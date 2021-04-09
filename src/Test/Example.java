package Test;

// 在方法里，引用类型改变指向的地址不会生效，即引用类型形参只能改变值，不能改变指向。
// 引用类型只能通过地址来达到改变值,而不能直接改变。
public class Example {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
}