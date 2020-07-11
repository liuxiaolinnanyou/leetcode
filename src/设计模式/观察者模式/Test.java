package 设计模式.观察者模式;

public class Test {
    public static void main(String[] args) {
        XiaoMei xiaoMei = new XiaoMei();
        LaoWang laoWang = new LaoWang();
        LaoLi laoLi = new LaoLi();

        // 小王和小李在小美那里都注册了一下
        xiaoMei.addPerson(laoWang);
        xiaoMei.addPerson(laoLi);

        // 小美向小王和小李发送通知
        xiaoMei.notifyPerson();
    }
}
