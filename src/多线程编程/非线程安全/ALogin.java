package 多线程编程.非线程安全;

public class ALogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}