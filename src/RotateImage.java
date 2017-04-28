/**
 * Created by apple on 17/4/27.
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 解题思路：原地算法
 时间复杂度： O(n)
 空间复杂度： 0(1)
 旋转图像顺时针90度。
 先将元素按照对角线对称交换
 再讲元素按照纵轴中线对称交换
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 1. 对称轴交换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0; j <= (n - 1) / 2; j++) {
                // 2. 纵轴对称变换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
