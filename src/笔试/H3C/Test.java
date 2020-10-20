package 笔试.H3C;

public class Test {
    String str1 = "hello";
    String str2 = new String("helloworld");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        Test test = new Test();
        test.change(test.str1, test.ch, test.str2);
        System.out.print(test.str1 + " and ");   // 为什么字符数组可以直接输出呢？为什么不是地址值呢？
        System.out.print(test.ch);              // char类型的数组就相当于一个字符串。
        System.out.println();
        System.out.println(test.str2);
    }

    public void change(String str1, char[] ch, String str2) {
        str1 = "test1 ok";
        str2 = "test2 ok";
        ch[0] = 'g';
    }
}