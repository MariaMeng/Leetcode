/**
 * Created by apple on 17/1/13.
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.
 */
public class RemoveDuplicatesFrSorted {
    /*
        采用two pointer，一个遍历
     */
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int j = 0; // current index
        int i = 1; // iterator through array
        for (; i < A.length; i++) {
            if (A[i] != A[j]) { //new number
                A[++j] = A[i]; // move current index, and fill the current index with new number
            }
        }
        return ++j; // j indexs from 0
    }
    public int removeDuplicates_another(int[] A) {
        if(A.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[j]) {
                j = j + 1;
                A[j] = A[i];
            }
        }
        return ++j;

    }
    public static void main(String[] args) {
        RemoveDuplicatesFrSorted mySolution = new RemoveDuplicatesFrSorted();
        int[] nums = {1, 1, 1};
        int result = mySolution.removeDuplicates(nums);
        System.out.println(result);
    }

}
