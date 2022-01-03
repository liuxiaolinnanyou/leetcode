package 注解与反射.反射;

import java.sql.Struct;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是：" + person.name);

        // 方式1
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        // 方式2
        Class c2 = Class.forName("注解与反射.反射.Student");
        System.out.println(c2.hashCode());

        // 方式3
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        // 方式4  仅对于基本内置类型的包装类
        Class type = Integer.TYPE;
        System.out.println(type);

        // 获得父类的类型
        Class superclass = c1.getSuperclass();
        System.out.println(superclass);
    }
}

class Person {
    public String name;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "老师";
    }
}