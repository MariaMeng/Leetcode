/**
 * Created by apple on 17/2/12.
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.
 解题思路：
 假设梯子有n层，那么如何爬到第n层呢，因为每次只能怕1或2步，那么爬到第n层的方法要么是从第n-1层一步上来的，
 要不就是从n-2层2步上来的，所以递推公式非常容易的就得出了：dp[n] = dp[n-1] + dp[n-2]。
 从n - 1上来的，则走法与前n - 1层的走法数相同；
 从n - 2上来的，则走法与前n - 2层的走法数相同。
 */
public class ClimbingStairs {

    /*
        方法一： My Own Solution
                Time Complexity: O(n)
                Space Complexity: O(n)
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
    /*
        方法二： Time Complexity: O(n)
                Space Complexity: O(1)
     */
    public int climbStairs_B(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }
    public static void main(String[] args) {
        ClimbingStairs mySolution = new ClimbingStairs();
        int result = mySolution.climbStairs(3);
        System.out.println(result);
    }
}
