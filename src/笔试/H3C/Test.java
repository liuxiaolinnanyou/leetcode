package 笔试.H3C;

public class Test {
    String str = "hello";
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        Test test = new Test();
        test.change(test.str, test.ch);
        System.out.print(test.str + " and ");   // 为什么字符数组可以直接输出呢？为什么不是地址值呢？
        System.out.print(test.ch);              // char类型的数组就相当于一个字符串。
    }

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }
}