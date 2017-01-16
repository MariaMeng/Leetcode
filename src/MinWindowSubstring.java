import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 17/1/8.
 * Given String s , String t
 * Return minimum Substring of s that contain all elements in String t
 */
public class MinWindowSubstring {

    /*
        方法一：采用 "10-line template"模板
        时间效率：6ms
     */
    public String minWindow(String s, String t) {
        int map[] = new int[128]; //ASCII表中一共有128个字符
        //初始化map
        for(char c : t.toCharArray()) //统计每个字符在字符串T中出现的次数
            map[c]++;

        int i = 0, j = 0; //two pointers, i为左窗口指针， j为右窗口指针
        int cnt = t.length(); //定义counter，初始值为字符串T长度，随着遍历，逐渐减小
        int min = Integer.MAX_VALUE; //子串的长度
        int start = 0;

        while(j < s.length()) { //遍历整个字符串S
            if(map[s.charAt(j++)]-- > 0) //判断当前遍历的右窗口字符在map中出现的次数，如果出现过1次或多次，则让cnt减一，并且map对应位置减一
                cnt--;
            while(cnt == 0) { //如果字符串T全部都遍历过了，counter condition

                //Update d here
                if(j - i < min) //如果窗口大小 小于 min
                    min = j - (start = i); //计算子串长度

                //increase begin to make it invalid/valid again
                if(map[s.charAt(i++)]++ == 0) //modify counter here 判断当前遍历的左窗口字符在map中出现的次数，
                    cnt++;
            }
        }
        return min == Integer.MAX_VALUE? "" : s.substring(start, start + min);

    }

    public String minWindow_another(String s, String t)  {
        int map[] = new int[128]; // define an array same size as ASCII,
        int counter = t.length(); //related with string t, control the loop, initial value is length of t
        int begin = 0, end = 0; // two pointers
        int d = Integer.MAX_VALUE; // the length of the substring
        int start = 0;

        /* Initialise the map in String t, store the occurrence of each character in the String t */
        for(char c : t.toCharArray()) {
            map[c]++;
        }
        while(end < s.length()) { //right pointer point to the String S
            if(map[s.charAt(end)] > 0) { // if this character has occurred in the string t
                /* modify the counter */
                counter--;
            }
            map[s.charAt(end)]--;
            end++;
            while(counter == 0) {
                /* update d here if find minimum substring */
                if (end - begin < d) {
                    d = end - (start = begin);
                }
                /* Increase begin to make it valid OR invalid */
                if(map[s.charAt(begin)] == 0) { //if this character has no occurrence in the map, this means this character has already been found in the string
                    counter++;
                }
                map[s.charAt(begin)]++;
                begin++;
            }

        }
        return d==Integer.MAX_VALUE? "" : s.substring(start, start + d);
    }



    public static void main(String[] args) {
        MinWindowSubstring mySolution = new MinWindowSubstring();
        String s="ADOBECODEBANC";
        String t="ABC";
        String result = mySolution.minWindow(s, t);

        /*
        char temp = 'A';
        System.out.println(map[temp]);
        char A = 65;
        System.out.println(A);//A虽然是数字，但是对应在ASCII中为A。
        char B = 65535;
        System.out.println(B);
        System.out.println(Integer.MAX_VALUE);
        */


    }
}
