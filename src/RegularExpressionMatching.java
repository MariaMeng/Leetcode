/**
 * Created by apple on 17/2/16.
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true

 This Solution use 2D DP. beat 90% solutions, very simple.

 Here are some conditions to figure out, then the logic can be very straightforward.

 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
 3, If p.charAt(j) == '*':
 here are two sub conditions:
 1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
 2   if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
 dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
 or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
 or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty

 */
public class RegularExpressionMatching {
    /*
    public boolean isMatch(String s, String p) {

    }
    */
    public static void main(String[] args) {
        String str = "aaa";

    }
}
