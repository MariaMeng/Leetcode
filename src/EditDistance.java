import java.util.Scanner;

/**
 * Created by apple on 17/4/6.
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 解题思路：
 dp[i][j]代表word1中的[0, i) 和 word2[0, j)中的最小的编辑距离
 相等 原问题 =》 dp[i - 1][j - 1]
 替换 原问题 =》 dp[i - 1][j - 1] + 1
 在word1中
 插入 原问题 =》 dp[i][j - 1] + 1
 删除 原问题 =》 dp[i - 1][j] + 1
 */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                if (a == b)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1)) ;
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // num of test case
        while (n-- != 0) {
            String word1 = in.next();
            String word2 = in.next();
            System.out.println(minDistance(word1, word2));
        }

    }
}
