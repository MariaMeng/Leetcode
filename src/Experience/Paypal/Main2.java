package Experience.Paypal;

import java.util.Scanner;

/**
 * Created by apple on 17/4/13.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        while (n-- != 0) {
            String[] str = in.nextLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            matrix[a - 1][b - 1] = 1;
        }

        int [][]dist = new int[n][n];
        int [][]path = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = matrix[i][j];
                path[i][j] = j;
            }
        }

        int m = in.nextInt();
        int[] special = new int[m];
        for (int i = 0; i < m; i++) {
            special[i] = in.nextInt();
        }

        // 计算最短路径
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int tmp = (dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE) ? Integer.MAX_VALUE : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp) {
                        dist[i][j] = tmp;
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

    }
}
