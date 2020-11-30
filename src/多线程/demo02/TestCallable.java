package 多线程.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

// 线程创建方式3：实现callable接口
// 好处：
// 1.可以定义返回值
// 2.可以抛出异常
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("http://img.netbian.com/file/2020/1129/7c415e665665d7b3915aa52345b64036.jpg", "英雄联盟.jpg");
        TestCallable t2 = new TestCallable("http://pic.netbian.com/uploads/allimg/201028/230944-160389778415e0.jpg", "妹子1.jpg");
        TestCallable t3 = new TestCallable("http://pic.netbian.com/uploads/allimg/190902/152344-1567409024d50f.jpg", "妹子2.jpg");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);
        // 获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        // 关闭服务
        ser.shutdown();
    }
}


// 下载器
class WebDownloader {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常, downloader方法出现问题");
        }
    }
}