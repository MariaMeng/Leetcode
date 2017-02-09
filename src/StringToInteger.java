/**
 * Created by apple on 17/2/3.
 * Implement atoi to convert a string to an integer.
 * 1. The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * 2. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * 3. The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * 4. If the first sequence of non-whitespace characters in str is not a valid integral number,
 *    or if no such sequence exists because either str is empty
 *                                          or it contains only whitespace characters,
 *    no conversion is performed.
 * 5. If no valid conversion could be performed, a zero value is returned.
 * 6. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;

        String s = str.trim();
        int sign = 1, start = 0, len = s.length();
        long sum = 0;

        if(s.charAt(0) == '+') {
            sign = 1;
            start++;
        }
        else if(s.charAt(0) == '-') {
            sign = -1;
            start++;
        }

        for(int i = start; i < len; i++) {
            if(!Character.isDigit(s.charAt(i)))
                return (int)sum * sign;
            sum = sum * 10 + s.charAt(i) - '0';
            if(sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int)sum * sign;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE/10);
        System.out.println(Integer.MAX_VALUE%10);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE/10);
        System.out.println(Integer.MIN_VALUE%10);

        String s = "test";
        System.out.println(s);

    }
}
