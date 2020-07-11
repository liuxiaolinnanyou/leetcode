package 测试;

public class LRU_test {
    public static void main(String[] args) {
        LRU<Integer, String> lru = new LRU<>(5);
        lru.put(1, "string1");
        lru.put(2, "string2");
        lru.put(3, "string3");
        lru.put(4, "string4");
        lru.put(5, "string5");
        lru.put(6, "string6");
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
        System.out.println(lru.get(6));
    }
}
