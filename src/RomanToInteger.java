import java.util.HashMap;

/**
 * Created by apple on 17/2/4.
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    /*
        方法一： My Own Solution ：方法速度太慢
                125ms
     */
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int sum = 0;
        for(int i = 0; i < len - 1; i++) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                sum -= map.get(s.charAt(i));
            else
                sum += map.get(s.charAt(i));
        }
        return sum + map.get(s.charAt(len - 1));
    }
    /*
        方法二： 对特殊6种数字，先差值计算，在进行每个字符求和计算。
                先在字符串中查找，是否包含 "IV,IX, XL, XC, CD, CM".
                89ms
     */
    public int romanToInt_B(String s) {
        int sum = 0;
        if(s.indexOf("IV") != -1) // if exist "IV" in s
            sum -= 2;
        if(s.indexOf("IX") != -1) // if exist "IX" in s
            sum -= 2;
        if(s.indexOf("XL") != -1) // if exist "XL" in s
            sum -= 20;
        if(s.indexOf("XC") != -1) // if exist "XC" in s
            sum -= 20;
        if(s.indexOf("CD") != -1) // if exist "CD" in s
            sum -= 200;
        if(s.indexOf("CM") != -1) // if exist "CM" in s
            sum -= 200;

        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (c[i] == 'M') sum += 1000;
            if (c[i] == 'D') sum += 500;
            if (c[i] == 'C') sum += 100;
            if (c[i] == 'L') sum += 50;
            if (c[i] == 'X') sum += 10;
            if (c[i] == 'V') sum += 5;
            if (c[i] == 'I') sum += 1;
        }
        return sum;
    }
    /*
        方法三：与方法一类似,但是速度快
               94ms
     */
    public int romanToInt_C(String s) {
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'M': array[i] = 1000; break;
                case 'D': array[i] = 500; break;
                case 'C': array[i] = 100; break;
                case 'L': array[i] = 50; break;
                case 'X': array[i] = 10; break;
                case 'V': array[i] = 5; break;
                case 'I': array[i] = 1; break;
            }
        }
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if(array[i] < array[i + 1])
                sum -= array[i];
            else
                sum += array[i];
        }
        return sum + array[s.length() - 1];
    }

    public static void main(String[] args) {
        RomanToInteger mySolution = new RomanToInteger();
        String s = "DCXXI";
        //String n = "";
        //String b = null;
        System.out.println(mySolution.romanToInt_C(s));
        //System.out.println(mySolution.romanToInt(n));
        //System.out.println(mySolution.romanToInt(b));
        String str = "Roman";
        System.out.println(str.indexOf("man"));
    }

}
