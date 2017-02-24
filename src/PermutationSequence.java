import java.util.*;

/**
 * Created by apple on 17/2/14.
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 *
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        List<Integer> number = new ArrayList<>();
        StringBuilder str= new StringBuilder();

        factorial[0] = 1;
        int sum = 1;
        for (int i = 1; i <=n; i++) {
            sum *= i;
            factorial[i] = sum;
        }

        for(int i = 1; i <= n; i++) {
            number.add(i);
        }

        k--;
        for (int i = 1; i <= n; i++) {
            int index = k/factorial[n - i];
            str.append(String.valueOf(number.get(index)));
            number.remove(index);
            k -= index * factorial[n - i];
        }
        return String.valueOf(str);
    }
    public static void main(String[] args) {
        PermutationSequence mySolution = new PermutationSequence();
        int n = 3, k = 2;
        String str = mySolution.getPermutation(n ,k);
        System.out.println(str);
    }
}
