import static java.lang.Math.max;

/**
 * Created by apple on 17/1/12.
 * Given String s,
 * Return the longest substring of String s without duplication
 *
 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubWithoutRC {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128]; //map
        int begin = 0, end = 0; // two pointers
        int start = 0;
        int d = 0; // the length of the substring
        int counter = 0; // duplicate character identifier


        while (end < s.length()) {
            if (map[s.charAt(end)] > 0) //if this character has been contained within the map, then counter++
                counter++;
            map[s.charAt(end)]++;
            end++;

            while (counter > 0) { //check whether
                if(map[s.charAt(begin)] > 1) //if this character is the same as the character which end point to
                    counter--;
                map[s.charAt(begin)]--;
                begin++;
            }
            d=java.lang.Math.max(d, end-begin); //while valid, update d
        }
        return d;
    }
    /*
        如果把题目改成返回substring，则用该方法
     */
    public String lengthOfLongestSubstring_Another(String s) {
        int[] map = new int[128]; //map
        int begin = 0, end = 0; // two pointers
        int start = 0;
        int d = 0; // the length of the substring
        int counter = 0; // sliding window size


        while (end < s.length()) {
            if (map[s.charAt(end)] > 0) //if this character has been contained within the map, then counter++
                counter++;
            map[s.charAt(end)]++;
            end++;

            while (counter > 0) {
                if(map[s.charAt(begin)] > 1) //if this character is the same as the character which end point to
                    counter--;
                map[s.charAt(begin)]--;
                begin++;
            }
            //d=java.lang.Math.max(d, end-begin); //while valid, update d
            if(end - begin > d) {
                d = end - (start = begin);
            }
        }
        return d == 0 ? "" : s.substring(start, start + d);

    }

    public static void main(String[] args) {
        LongestSubWithoutRC mySolution = new LongestSubWithoutRC();
        String s = "ABCABCBB";
        String c = "PWWKEW";
        String d = "ddddd";
        System.out.println(mySolution.lengthOfLongestSubstring(d));
        System.out.println(mySolution.lengthOfLongestSubstring_Another(d));

    }

}
