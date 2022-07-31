package JavaStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonStream {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("小张", "江苏", 22));
        list.add(new Person("小李", "重庆", 18));
        list.add(new Person("小赵", "唐山", 55));
        list.add(new Person("小明", "天津", 24));
        list.add(new Person("小红", "江苏", 18));
        list.add(new Person("小张", "江苏", 48));

        // 遍历list
        for (Person person : list) {
            System.out.println(person.getName() + ":" + person.getAddress() + ":" + person.getAge());
        }
        System.out.println();

        list = new ArrayList<>(list.stream().collect(Collectors.toMap(a -> a.getName() + "-" + a.getAddress(), l -> l, (o1, o2) -> {
            o1.setAge(o1.getAge() + o2.getAge());
            return o1;
        })).values());

        // 遍历list
        for (Person person : list) {
            System.out.println(person.getName() + ":" + person.getAddress() + ":" + person.getAge());
        }
    }
}
