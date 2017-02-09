/**
 * Created by apple on 17/2/2.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class LongestPalindromicSubstring {


    /*
        方法一： 采用Top Solution中(AC) relatively short and very clear Java solution
                24ms
     */
    public String longestPalindrome_A(String s) {
        String res = "";
        int currLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s,i - currLength - 1, i)){
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            }
            else if(isPalindrome(s,i - currLength, i)){
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return res;
    }

    /*
        begin: 初始位置
        end: 末位置
     */
    public boolean isPalindrome(String s, int begin, int end) {
        if(begin < 0) return false;

        while(begin < end) {
            if(s.charAt(begin) != s.charAt(end)) return false;
            begin++;
            end++;
        }
        return true;
    }

    /*
        方法二： Very simple clean java solution
                该方法逐个查找包括每个点，以及两点之间的空隙
                15ms
     */
    private int lo, maxLen;


    public String longestPalindrome_B(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        // expand
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        //update maxLen
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }



    public static void main(String[] args) {
        int[] temp = new int[0];
        System.out.println(temp.length);
        String s = "aaaa";
        s.substring(1,2);
    }
}
