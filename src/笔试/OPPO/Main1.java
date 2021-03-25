package 笔试.OPPO;

// AC 80

/**
 * 给定两个任意大小的正整数，计算这两个数的和或者差。
 * <p>
 * 输入：["22222222222222222222","-","11111111111111111111"]
 * 输出："11111111111111111111"
 * <p>
 * 输入：["70","+","1000"]
 * 输出："1070"
 */
public class Main1 {
    public static void main(String[] args) {
        String[] s = {"22222222222222222222", "-", "11111111111111111111"};
        System.out.println(caculateResult(s));
    }

    public static String caculateResult(String[] values) {
        // write code here
        boolean fh = false;
        if (values[1].equals("-")) {
            return caculateResult2(values[0], values[2]);
        }
        String str1 = values[0];
        String str2 = values[2];
        int lenA = str1.length();
        int lenB = str2.length();
        int lenS = Math.max(lenA, lenB);     // 存放两个字符串长度的较大值

        // arrS保存最终生成的结果
        int[] arrA = new int[lenS];
        int[] arrB = new int[lenS];
        int[] arrS = new int[lenS + 1];

        for (int i = 0; i < lenA; i++) {
            arrA[i] = str1.charAt(lenA - 1 - i) - '0';
        }

        for (int i = 0; i < lenB; i++) {
            arrB[i] = str2.charAt(lenB - 1 - i) - '0';
        }

        for (int i = 0; i < lenS; i++) {
            int sum = arrS[i] + arrA[i] + arrB[i];
            int flag = sum / 10;
            arrS[i] = sum % 10;
            arrS[i + 1] += flag;
        }

        String s = "";
        for (int i = arrS[lenS] == 0 ? 1 : 0; i < lenS + 1; i++) {
            s += arrS[lenS - i];
        }
        return s;
    }

    private static String caculateResult2(String a, String b) {
        char[] numA = new StringBuilder(a).reverse().toString().toCharArray();
        char[] numB = new StringBuilder(b).reverse().toString().toCharArray();
        int[] result = new int[numA.length];
        for (int i = 0; i < result.length; i++) {
            int intA = i < numA.length ? numA[i] - '0' : 0;
            int intB = i < numB.length ? numB[i] - '0' : 0;
            result[i] = intA - intB;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }
        StringBuilder sbr = new StringBuilder();
        boolean bool = true;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0 && bool) {
                bool = false;
                continue;
            }
            sbr.append(result[i]);
        }
        return sbr.toString();
    }
}
