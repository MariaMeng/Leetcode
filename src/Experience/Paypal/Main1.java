package Experience.Paypal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by apple on 17/4/13.
 * Calculate survival fishes
 时间限制：1秒
 空间限制：32768K
 题目描述
 Given two zero-indexed arrays A and B consisting of N (N >= 0) integers, which represent N fishes in a river, ordered from west to east.
 The fish are numbered from 0 to N-1, and Fish number X is represented by A[X] and B[X]. Array A contains the sizes of the fishes, while array B contains the directions they swim, which can be 1 (from west to east) or -1 (from east to west).

 If two fishes move in opposite directions meet each other, the larger fish will eat the smaller one, and the survival will still follow its original direction.

 We assume that all fishes are in different sizes and swimming at the same speed. The goal is to calculate the number of fishes that will stay alive.

 For example:

 A is [3, 5, 9, 1, 2]
 B is [1, -1, 1, 1, -1]

 Fish number 1 will eat Fish number 0, Fish number 4 will eat Fish number 3 and be eaten by Fish number 2. Therefore the output should be 2 (Fish number 1 and Fish number 2 are still alive)
 输入描述:
 Array A and B as described above


 输出描述:
 The number of fishes that will stay alive

 输入例子:
 3 5 9 1 2
 1 -1 1 1 -1

 输出例子:
 2
 */
public class Main1 {
    public static int getSurvive(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 0) return 0;

        //int n = A.size();
        int count = 0;
        for (int i = 1; i < A.size(); i++) {
            if (B.get(i) == -1 && B.get(i - 1) == 1) {
                if (A.get(i) > A.get(i - 1)) {

                    B.remove(i - 1);
                    A.remove(i - 1);

                } else if(A.get(i) < A.get(i - 1)){

                    B.remove(i);
                    A.remove(i);

                }
            } else // 没有这种情况
                count++;
        }
        // No
        if (count == A.size() - 1) {
            return count + 1;
        } else
            return getSurvive(A, B);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        String[] str2 = in.nextLine().split(" ");
        int n = str.length;

        /*
        int[] A = new int[n];
        int[] B = new int[n];
        */
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            /*
            A[i] = Integer.parseInt(str[i]);
            B[i] = Integer.parseInt(str2[i]);
            */
            A.add(Integer.parseInt(str[i]));
            B.add(Integer.parseInt(str2[i]));
        }
        System.out.println(getSurvive(A, B));
    }
}
