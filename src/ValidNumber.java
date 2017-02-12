/**
 * Created by apple on 17/2/9.
 * Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

 注意事项：
 1) For instance: "  -1.34e-2  "(有空格)
                  " -3.e-2  "(有空格)
 2) +- 号： 如果当前不是首位置，且前方不是e, 怎返回false。 （包含了很多种错误情况）
 3) .号： 前方不能有点
          前方不能有e
 4) e号： 前方不能没有数字
         前方不能有e
         后方不能没有数字
 5) 空格！！！！
 6) 4个pointer： pointSeen: 判断前面是否有point
                eSeen: 判断前面是否有e
                numberSeen: 判断前面是否有数字
                numberAfterE: 判断是否e之后是否有数字
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;

        s = s.trim();

        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (pointSeen || eSeen)
                    return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen)
                    return false;
                eSeen = true;
                numberAfterE = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else
                return false;
        }
        return numberAfterE && numberSeen;
    }

    public static void main(String[] args) {
        System.out.println(3.e-2);
    }
}
