package 测试3;

public class Test1 {
    private static int i = 1;

    public int getNext() {
        return i++;
    }

    public static void main(String[] args) {
        Test1 test = new Test1();
        Test1 testObject = new Test1();
        test.getNext();
        testObject.getNext();
        System.out.println(testObject.getNext());       // 静态成员是所有对象共享的
//        System.out.println(test.getNext());
    }
}