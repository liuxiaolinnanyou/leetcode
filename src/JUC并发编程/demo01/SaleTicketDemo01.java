package JUC并发编程.demo01;

public class SaleTicketDemo01 {
    public static void main(String[] args) {
        // 并发：多个线程操作同一个资源类   把资源类丢入线程
        Ticket ticket = new Ticket();

        // @FunctionalInterface   函数式接口
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "C").start();

    }
}

// 资源类
class Ticket {
    // 属性  方法
    private int number = 50;

    // 卖票的方式
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + number-- + "票");
        }
    }

    // 对象
    // class
}