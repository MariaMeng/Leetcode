import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by maria on 17-5-26.
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    /*
        方法一： 笨方法：采用map遍历两个字符串
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0) return true;
        if (s.length() != t.length()) return false;
        if (s == null || t == null) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        // 1. 遍历整个s字符串
        for (char sub : charS) {
            if (map.containsKey(sub)) {
                map.put(sub, map.get(sub) + 1);
            } else
                map.put(sub, 1);
        }
        // 2. 遍历整个t字符串
        for (char sub: charT) {
            if (map.containsKey(sub)) {
                map.put(sub, map.get(sub) - 1);
                if (map.get(sub) == 0) {
                    map.remove(sub);
                }
            } else {
                return false;
            }
        }
        if (map.size() != 0) return false;
        else return true;
    }

    /*
        方法二： 速度快！
     */
    public boolean isAnagram_B(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return String.valueOf(sArr).equals(String.valueOf(tArr));
    }
    public static void main(String[] args) {

    }
}
