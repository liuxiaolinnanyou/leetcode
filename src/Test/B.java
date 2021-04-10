package Test;

public class B {
    public static void main(String[] args) {
        C f = new C();
        f.show();
    }
}

class F {
    int age = 23;

    public void show() {
        System.out.println(this.age);
    }
}

class C extends F {
    int age = 5;
}