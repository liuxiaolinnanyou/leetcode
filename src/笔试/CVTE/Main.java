package 笔试.CVTE;

// 数组中大于一半的数。
public class Main {
    public static void main(String[] args) {

    }

    public static int countGroupAgeMoreThanHalf(int groupAges[]) {
        if (groupAges == null || groupAges.length == 0) {
            return 0;
        }
        int preValue = groupAges[0];
        int count = 1;
        for (int i = 1; i < groupAges.length; i++) {
            if (groupAges[i] == preValue)
                count++;
            else {
                count--;
                if (count == 0) {
                    preValue = groupAges[i];
                    count = 1;
                }
            }
        }

        int num = 0;
        for (int i = 0; i < groupAges.length; i++) {
            if (groupAges[i] == preValue) {
                num++;
            }
        }
        return (num > groupAges.length / 2) ? preValue : 0;
    }
}