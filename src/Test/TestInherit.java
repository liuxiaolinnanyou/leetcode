package Test;

public class TestInherit {
    public static void main(String[] args) {
        Base base = new Derived();
        base.f();
        base.g();
    }
}

class Base {
    public Base() {
        g();
    }

    public void f() {
        System.out.println("Base f()");
    }

    public void g() {
        System.out.println("Base g()");
    }
}

class Derived extends Base {
    public void f() {
        System.out.println("Derived f()");
    }

    public void g() {
        System.out.println("Derived g()");
    }
}