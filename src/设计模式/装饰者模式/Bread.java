package 设计模式.装饰者模式;

// 面包类
public class Bread extends Food {
    private Food basicFood;

    public Bread(Food basicFood) {
        this.basicFood = basicFood;
    }

    public String make() {
        return basicFood.make() + "+面包";
    }
}
