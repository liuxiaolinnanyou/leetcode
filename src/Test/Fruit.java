package Test;

/**
 * 注意比较Comparable接口和Comparator接口的区别
 * java.lang.Comparable                  compareTo方法
 * java.util.Comparator                  compare方法
 */
public class Fruit implements Comparable<Fruit> {
    String name;
    int id;
    int weight;

    public Fruit(String name, int id, int weight) {
        this.name = name;
        this.id = id;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }


    @Override
    public int compareTo(Fruit f) {
        int num1 = this.name.compareTo(f.name);
        int num2 = num1 == 0 ? this.weight - f.weight : num1;
        int num3 = num2 == 0 ? this.id - f.id : num2;
        return num3;
    }
}