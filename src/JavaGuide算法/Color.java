package JavaGuide算法;

/**
 * 枚举类型是java5新增的特性，它是一种新的类型，允许用常量来表示特定的数据片段，而且全部都以类型安全的形式来表示。
 * 所有的枚举都继承自java.lang.Enum类。由于java不支持多继承，所以枚举对象不能再继承其他类(可以实现接口)。
 */
public enum Color {
    RED(1, "红色"),
    GREEN(2, "绿色"),
    BLANK(3, "黑色"),
    YELLOW(4, "黄色");


    private int code;
    private String message;

    Color(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
