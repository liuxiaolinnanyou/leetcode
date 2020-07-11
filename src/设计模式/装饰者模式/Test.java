package 设计模式.装饰者模式;

/**
 * 一层一层封装，我们从里往外看：最里面我new了一个香肠，在香肠的外面我包裹了一层奶油，
 * 在奶油的外面我又加了一层蔬菜，最外面我放的是面包
 */
public class Test {
    public static void main(String[] args) {
        Food food = new Bread(new Vegetable(new Cream(new Food("小腊肠"))));
        System.out.println(food.make());
    }
}
