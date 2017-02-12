/**
 * Created by apple on 17/2/9.
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 解题思路：
 1. 从右往左按位加：两个 counter 管理 字符串a 字符串b 的位置。
 2. 求%为当前位数结果
 3. 求/为carry位
 */
public class AddBinary {
    /*
        方法一：采用Add Two numbers方法
     */
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int sum = 0;
        StringBuilder str = new StringBuilder();
        while(i > -1 || j > -1) {
            sum /= 2;
            if (i > -1) sum += a.charAt(i--) - '0';
            if (j > -1) sum += b.charAt(j--) - '0';
            str.append(sum % 2);
        }
        if (sum / 2 == 1) str.append(1);

        return str.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "1011";
        /*
        System.out.println(Integer.SIZE);
        System.out.println(Character.SIZE);
        System.out.println(Byte.SIZE);
        System.out.println(Long.SIZE);
        */
        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('1'));
        char c = '\u216C'; // roman number L
        System.out.println(c);
        System.out.println(Character.getNumericValue(c));
    }
}
