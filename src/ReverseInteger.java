/**
 * Created by apple on 17/2/16.
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Have you thought about this?
 Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 Note:
 The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 注意事项：
 1. 如果末尾为零，怎么办？
 2. 如果反转之后，溢出，则返回0.
 3. 包括负数
 */

public class ReverseInteger {
    /*
        方法一：
     */
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
    /*
        方法二：
     */
    public int reverse_B(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
            x = x / 10;
        }
        return (int) rev;
    }
    public static void main(String[] args) {
        ReverseInteger mySolution = new ReverseInteger();
        int result = mySolution.reverse(1000000003);
        System.out.println(result);

        long a = (long)300000000 * 10 + 1;
        System.out.println(a);
        System.out.println(300000000 * 10 + 1);
        long b = a - Integer.MAX_VALUE - 1;
        int d = Integer.MIN_VALUE + (int)b;
        System.out.println(d);
    }
}
