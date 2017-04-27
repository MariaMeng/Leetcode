package Experience.Wezhong;

import java.util.Scanner;

/**
 * Created by apple on 17/4/25.
 */
public class Main1 {
    public static int ways(int[] ability, int [] data, int target) {
        //int[][][] matrix = new int[data[0]][data[1]][data[2]];
        int sum = 0;
        int count = 0;
        int x = data[0];
        int y = data[1];
        int z = data[2];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    //matrix[i][j][k] = i * ability[0] + j * ability[1]  + k * ability[2];
                    sum = i * ability[0] + j * ability[1]  + k * ability[2];
                    if (sum == target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] data = new int[3];
        for (int i = 0; i < 3; i++) {
            data[i] = in.nextInt(); // 人数
        }

        int[] ability = new int[]{5, 8, 10};
        System.out.println(ways(ability, data, n));
    }
}
