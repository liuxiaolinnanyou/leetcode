package 设计模式.装饰者模式;

// 奶油类
public class Cream extends Food{
    private Food basicFood;

    public Cream(Food basicFood) {
        this.basicFood = basicFood;
    }

    public String make() {
        return basicFood.make() + "+奶油";
    }
}
