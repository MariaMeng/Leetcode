/**
 * Created by apple on 17/2/1.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    /*
        方法一： My own Solution 采用 two pointers
                9ms
                Time Complexity O(n)
                Space Complexity O(n)
     */
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        char[] letter = s.toLowerCase().toCharArray();
        int i = 0, j = letter.length - 1; // two pointers
        while( i <= j) {
            while(i <= j && (letter[i] < 48 || letter[i] > 57 && letter[i] < 65 || letter[i] > 90 && letter[i] < 97 || letter[i] > 122))
                i++;
            while(i <= j && (letter[j] < 48 || letter[j] > 57 && letter[j] < 65 || letter[j] > 90 && letter[j] < 97 || letter[j] > 122))
                j--;
            if(i > j ) break;
            if(letter[i] != letter[j])
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
    /*
        方法二： 采用封装类的相关方法
                8ms
                Time Complexity O(n)
                Space Complexity O(1)
     */
    public boolean isPalindrome_B(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
    /*
        方法三： 采用StringBuilder方法
        64ms
     */
    public boolean isPalindrome_C(String s) {
        String another = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        String rev = new StringBuffer(another).reverse().toString();
        return another.equals(rev);
    }
    public static void main(String[] args) {

    }
}
