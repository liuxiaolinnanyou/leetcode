package 注解与反射.反射;

public class Test01 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取类的Class对象
        Class c1 = Class.forName("注解与反射.反射.User");
        System.out.println(c1);

        Class c2 = Class.forName("注解与反射.反射.User");
        Class c3 = Class.forName("注解与反射.反射.User");
        Class c4 = Class.forName("注解与反射.反射.User");

        /**
         * hashCode 一样   是同一个类(一个类在内存中只有一个Class对象)
         * 一个类被加载后，类的整个结构都会被封装在Class对象中
         */
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }
}

class User {
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}