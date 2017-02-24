/**
 * Created by apple on 17/2/22.
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 */
public class PalindromeNumber {
    /*
        9889
        10000
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while(x / div >= 10) {
            div *= 10;
        }
        while(x > 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = (x % div) / 10;
            div = div / 100;
        }
        return true;
    }
    public static void main(String[] args) {
        int num = 9889;
        PalindromeNumber mySolution = new PalindromeNumber();
        boolean result = mySolution.isPalindrome(num);
        System.out.println(result);
    }
}
