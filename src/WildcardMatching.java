import com.sun.org.apache.xerces.internal.impl.xs.XSWildcardDecl;

import java.util.Scanner;

/**
 * Created by apple on 17/4/12.
 * Implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int match = 0, nextIdx = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                nextIdx = j;
                match = i;
                j++;
            } else if (nextIdx != -1) {
                j = nextIdx + 1;
                match++;
                i = match;
            } else
                return false;
        }
        while (j < p.length()) {
            if (p.charAt(j) == '*') j++;
            else break;
        }
        return j == p.length();
    }
    public static void main(String[] args) {
        WildcardMatching my = new WildcardMatching();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            String p = in.next();
            System.out.println(my.isMatch(s, p));
        }
    }
}
