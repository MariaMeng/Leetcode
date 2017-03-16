/**
 * Created by apple on 17/3/11.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class SearchA2DMatrix {
    /*
        方法一： 采用Binary Search方法
        Time Complexity: O(log n)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1; // two pointers
        while(left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid / n][mid % n] < target)
                left = mid + 1;
            else if (matrix[mid / n][mid % n] > target)
                right = mid - 1;
            else
                return true;
        }
        return false;
    }
}
