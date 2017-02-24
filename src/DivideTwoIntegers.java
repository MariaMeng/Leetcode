/**
 * Created by apple on 17/2/23.
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 dividend: 被除数
 divisor: 除数
 解题思路：
 1. 采用按位操作方法
 2. 除数每次变为原来2倍，然后与被除数（dividend）比较
 3. 用一个count维护满足dividend > divisor 的次数
 4. 注意边界条件。(Overflow情况) 一种是divisor为零， 另一种是dividend为整数最小值，divisor为-1。
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // Overflow
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1; // if either the dividend or divisor < 0
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);

        int res = 0;
        while(dvd >= dvs) {
            long temp = dvs, multiple = 1;
            while(dvd > (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }
        return sign == 1 ? (int)res: -(int)res;
    }

    public static void main(String[] args) {
        DivideTwoIntegers mySolution = new DivideTwoIntegers();
        int dividend = Integer.MIN_VALUE, divisor = 1;
        int result = mySolution.divide(dividend, divisor);
        System.out.println(result);

        long a = (long)Integer.MIN_VALUE * (-1);
        System.out.println(a);
        System.out.println((int)a);
        System.out.println(-(int)a);

    }
}
