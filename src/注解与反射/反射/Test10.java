package 注解与反射.反射;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 */
public class Test10 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("注解与反射.反射.Dog");

        // 通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得注解的value的值
        TableName tableName = (TableName) c1.getAnnotation(TableName.class);
        String value = tableName.value();
        System.out.println(value);

        // 获得类指定的注解
        Field name = c1.getDeclaredField("name");
        FieldName annotation = name.getAnnotation(FieldName.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@TableName("db_dog")
class Dog {
    @FieldName(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldName(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FieldName(columnName = "db_name", type = "varchar", length = 10)
    private String name;

    public Dog() {
    }

    public Dog(int id, int age, String name) {
        this.id = id;
        this.age = age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

// 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableName {
    String value();
}

// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldName {
    String columnName();

    String type();

    int length();
}