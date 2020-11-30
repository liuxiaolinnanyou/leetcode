package 多线程.demo03;

public class TestLambda2 {
    public static void main(String[] args) {
        ILove love = null;

        // 1.lambda表达式简化
//        ILove love = (int a) -> {
//            System.out.println("i love you-->" + a);
//        };

        // 简化1    参数类型
//        love = (a) -> {
//            System.out.println("i love you-->" + a);
//        };

        // 简化2    简化括号
//        love = a -> {
//            System.out.println("i love you-->" + a);
//        };

        // 简化3    去掉花括号
        love = a -> System.out.println("i love you-->" + a);
        love.love(521);

        /**
         * 总结：
         * 1. lambda表达式只有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹。
         * 2. 前提是接口为函数式接口
         * 3. 多个参数也可以去掉参数类型，要去掉就都去掉，必须加上括号
         */
    }
}

interface ILove {
    void love(int a);
}

//class Love implements ILove {
//    @Override
//    public void love(int a) {
//        System.out.println("i love you-->" + a);
//    }
//}