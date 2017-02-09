/**
 * Created by apple on 17/2/4.
 * Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
    /*
        方法一： easy to understand
     */
    public String intToRoman(int num) {
        //int[] values = {1,    4,    5,   9,   10,   40,  50,   90,  100, 400,  500, 900, 1000};
        //String[] str = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1000, 900, 500, 400,  100,  90,  50,   40,  10,    9,   5,   4,    1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < values.length; i++) {
            while(num >= values[i]) {
                num -= values[i];
                builder.append(str[i]);
            }
        }
        return builder.toString();
    }
    /*
        方法二： 速度快
     */
    public String intToRoman_B(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args) {
        IntegerToRoman mySolution = new IntegerToRoman();
        System.out.println(mySolution.intToRoman(88));
    }
}
