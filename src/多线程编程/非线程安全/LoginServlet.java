package 多线程编程.非线程安全;

import java.util.concurrent.TimeUnit;

/**
 * 模拟成一个Servlet组件
 */
public class LoginServlet {
    private static String userNameRef;
    private static String passWordRef;

    public static void doPost(String userName, String passWord) {
        try {
            userNameRef = userName;
            if (userName.equals("a")) {
                TimeUnit.SECONDS.sleep(5);
            }
            passWordRef = passWord;
            System.out.println("userName=" + userNameRef + " passWord=" + passWord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}