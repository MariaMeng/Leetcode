/**
 * Created by apple on 17/1/31.
 */
public class MergeSortedArray {
    /*
        方法一： 采用two pointers 方法，从后往前遍历，因为由题已知，数组A的大小足够容纳num1和num2
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1; // two pointers
        int k = m + n - 1; // the last index of the merged array
        while(i >= 0 && j >= 0) {
            if(A[i] > B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }

        while(j >= 0) // 如果A遍历完之后，B仍没遍历完
            A[k--] = B[j--];
    }
    /*
        方法二： 函数减少
     */
    public void merge_B(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n -1, k = m + n - 1;
        while(i > -1 && j > -1) A[k--] = A[i] > B[j] ? A[i--] : B[j--];
        while(j > -1) A[k--] = B[j--];
    }
}
