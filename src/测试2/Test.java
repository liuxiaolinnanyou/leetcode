package 测试2;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static final class Person {
        private String name = "";

        public Person(String n) {
            setName(n);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = (name == null) ? "" : name;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Person)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return this.name.equals(((Person) obj).name);
        }

        @Override
        public int hashCode() {
            return name.length();
        }
    }

    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();
        Person person = new Person("nowcoder");
        persons.add(person);
        person.setName("nowcodertest");
        boolean isContains = persons.contains(person);
        int size = persons.size();
        System.out.println("isContains=" + isContains);
        System.out.println("size=" + size);
    }
}
