package Experience;

/**
 * Created by apple on 16/12/27.
 */
public class Solution {
    public void sortIntegers(int[] A) {
        // Write your code here
        for(int i=0;i<=A.length;i++){
            int k,j;
            for(k=i,j=i+1;j<A.length;j++) {
                if (A[j] < A[k])
                    k = j;
            }
            if(k!=i) {
                A[i] = A[i] ^ A[k];
                A[k] = A[i] ^ A[k];
                A[i] = A[i] ^ A[k];
            }
        }

        System.out.println("for test~");
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
    }
    public static void main(String[] args){
        Solution mySolution=new Solution();
        int[] A={3,2,1,4,5};
        mySolution.sortIntegers(A);

    }
}
