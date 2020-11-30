package 多线程;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 练习Thread 实现多线程同步下载图片
public class TestThread2 extends Thread {
    private String url;    // 网络图片地址
    private String name;   // 保存的文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("http://img.netbian.com/file/2020/1129/7c415e665665d7b3915aa52345b64036.jpg", "英雄联盟.jpg");
        TestThread2 t2 = new TestThread2("http://pic.netbian.com/uploads/allimg/201028/230944-160389778415e0.jpg", "妹子1.jpg");
        TestThread2 t3 = new TestThread2("http://pic.netbian.com/uploads/allimg/190902/152344-1567409024d50f.jpg", "妹子2.jpg");

        t1.start();
        t2.start();
        t3.start();
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