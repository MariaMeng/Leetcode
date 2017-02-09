import java.util.Arrays;

/**
 * Created by apple on 17/1/15.
 * Given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {

    /*
        方法一：从if(A[i] == elem)角度
        Correct Answer!!
        The basic idea is when elem is found at index i, let A[i] = the last element in the modifying array,
        then repeat searching until elem is not found.
     */
    public int removeElement_A(int[] A, int elem) {
        int len = A.length;
        for (int i = 0 ; i< len; ++i){
            while (A[i]==elem && i< len) {
                A[i]=A[--len];
            }
        }
        return len;
    }

    /*
       对removeElement_A部分代码的展开
     */
    public int removeElement_A_another(int[] A, int elem) {
        int len = A.length;
        int i = 0;
        for (; i < len; i++) {
            while(A[i] == elem && i < len) {
                len--;
                A[i] = A[len];
            }
        }
        return len;
    }

    /*
        removeElement_A的变体，意思一样的
     */
    public int removeElement_C(int[] A, int elem) {
        int l = A.length;
        for (int i=0; i<l; i++) {
            if (A[i] == elem) {
                A[i--] = A[l-- -1];
            }
        }
        return l;
    }
    /*
        对removeElement_C的展开
     */
    public int removeElement_C_another(int[] A, int elem) {
        int l = A.length;
        for (int i = 0; i < l; i++) {
            if(A[i] == elem) {
                A[i] = A[l - 1];
                i--;
                l--;
            }
        }
        return l;
    }


    /*
        方法二：从 if(A[i] != elem)角度
        未排序，只要当前元素！= target,则左指针++
     */
    public int removeElement_B(int[] A, int elem) {
        int m = 0; //current index
        for(int i = 0; i < A.length; i++){ //iterator through array
            if(A[i] != elem){
                A[m] = A[i];
                m++;
            }
        }

        return m;
    }

    public static void main(String[] args) {
        RemoveElement mySolution = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int[] another = {4, 5};
        int[] B = {1, 1, 2, 2, 3};
        int[] C= {1, 2, 2, 2, 1, 3};
        int target = 1;
        int result = mySolution.removeElement_B(C, target);
        System.out.println(result);
    }

}
