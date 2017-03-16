/**
 * Created by apple on 17/2/28.
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
    public static void main(String[] args) {
        PowerOfFour mySolution = new PowerOfFour();
        int num =(Integer.MAX_VALUE >> 3) + 1;
        boolean result = mySolution.isPowerOfFour(num);
        System.out.println(result);
    }

}
