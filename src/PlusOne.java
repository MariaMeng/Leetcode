import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by apple on 17/4/27.
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.

 将一个数字的每个位上的数字分别存到一个一维向量中，最高位在最开头，
 我们需要给这个数字加一，即在末尾数字加一，
 如果末尾数字是9，那么则会有进位问题，
 而如果前面位上的数字仍为9，则需要继续向前进位。
 大端模式
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n + 1];
        newNumber[0] = 1;

        return newNumber;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.next().split("");
        int n = str.length;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(str[i]);
        }
        data = plusOne(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
    }
}
