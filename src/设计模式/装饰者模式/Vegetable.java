package 设计模式.装饰者模式;

// 蔬菜类
public class Vegetable extends Food{
    private Food basicFood;

    public Vegetable(Food basicFood) {
        this.basicFood = basicFood;
    }

    public String make() {
        return basicFood.make() + "+蔬菜";
    }
}
