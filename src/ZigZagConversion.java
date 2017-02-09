/**
 * Created by apple on 17/2/5.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    /*
        方法一： Easy to understand Java solution方法
                Time Complexity: O(n)
                Space Complexity: O(n)
     */
    public String convert(String s, int numRows) {
        //1. 把字符串转换成字符数组
        char[] c = s.toCharArray();
        int len = c.length;

        //2. create StringBuffer数组
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuffer();

        //3. 把对应位置字符插入到字符串中,i 控制字符数组下标，idx控制行数
        int i = 0; //control the index of char array
        while(i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) { //vertically down
                sb[idx].append(c[i++]);
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) { //obliquely up
                sb[idx].append(c[i++]);
            }
        }
        //4. Assemble the StringBuffer array into a String Buffer
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
    /*
        方法二： A 10-lines one-pass o(n)-time o(1)-space accepted solution with detailed explanation
                采用周期性方法 计算周期cycle大小
                Time Complexity: O(n)
                Space Complexity: O(1)
     */
    public String convert_B(String s, int nRows) {
        if (nRows <= 1) return s;
        StringBuilder result = new StringBuilder();
        //the size of a cycle(period)
        int cycle = 2 * nRows - 2;
        //遍历 each row
        for (int i = 0; i < nRows; ++i) {
            //遍历每个周期
            for (int j = i; j < s.length(); j = j + cycle) {
                //add 每个周期中每行的节点
                result.append(s.charAt(j));
                int secondJ = (j - i) + cycle - i;

                if (i != 0 && i != nRows - 1 && secondJ < s.length())
                    result.append(s.charAt(secondJ));
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.toString();
        str.reverse().toString();
    }
}
