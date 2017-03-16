/**
 * Created by apple on 17/3/11.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.
 */
public class SearchA2DMatrixII {

    /*
        方法一： 采用divide and conquer方法
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        return search(new int[]{0, 0}, new int[]{m - 1, n - 1}, matrix, target);
    }
    private boolean search(int[] leftTop, int[] rightBottom, int[][] matrix, int target) {
        if(leftTop[0]>rightBottom[0] || leftTop[1]>rightBottom[1]
                || rightBottom[0]>=matrix.length || rightBottom[1]>=matrix[0].length)
            return false;
        if (leftTop[0] == rightBottom[0] && leftTop[1] == rightBottom[1]) return matrix[leftTop[0]][leftTop[1]] == target;
        int midRow = (leftTop[0] + rightBottom[0]) / 2;
        int midCol = (leftTop[1] + rightBottom[1]) / 2;

        if (matrix[midRow][midCol] < target)
            return search(new int[]{leftTop[0], midCol + 1}, new int[]{midRow, rightBottom[1]}, matrix, target) ||
                    search(new int[]{midRow + 1, leftTop[1]}, new int[]{rightBottom[0], midCol}, matrix, target) ||
                    search(new int[]{midRow + 1, midCol + 1}, new int[]{rightBottom[0], rightBottom[1]}, matrix, target);
        else if (matrix[midRow][midCol] > target) {
            return search(leftTop, new int[]{midRow - 1, midCol - 1}, matrix, target)||
                    search(new int[]{leftTop[0], midCol}, new int[]{midRow - 1, rightBottom[1]}, matrix, target)||
                    search(new int[]{midRow, leftTop[1]}, new int[]{rightBottom[0], midCol - 1}, matrix, target);
        }
        else return true;
    }

    /*
        方法二： 采用从右上角开始遍历,或者左下角遍历
        Time Complexity: O(m + n)
     */
    public boolean searchMatrix_B(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        // from rightTop corner
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0) {
            if (target > matrix[row][col])
                row++;
            else if (target < matrix[row][col])
                col--;
            else return true;
        }
        return false;
    }
    public static void main(String[] args) {
        /*
        int[] a = new int[0];
        int[] b = new int[] {1, 2};
        System.out.println(b.length);
        char[] c = new char[]{'a', 'b', 'c'};
        System.out.println(c);
        */
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{1, 5, 7, 9, 11};
        matrix[1] = new int[]{2, 6, 11, 12, 13};
        matrix[2] = new int[]{3, 4, 15, 16, 17};
        matrix[3] = new int[]{4, 25, 26, 27, 28};
        SearchA2DMatrixII my = new SearchA2DMatrixII();
        int target = -1;
        boolean result = my.searchMatrix_B(matrix, target);
        System.out.println(result);
    }
}
