import java.util.Scanner;

/**
 * Created by apple on 17/4/13.
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 题意：
 这道题可以有K次
 可以不使用数组维护
 */
public class BestTimetoBuyandSellStockIV {
    public static int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n]; // 到第i个位置之前需要cut的个数
        boolean[][] pal = new boolean[n][n]; // 第i个位置于第j个位置是否相等

        for(int i = 0; i < n; i++) {
            int min = i; //至多分割的次数
            for(int j = 0; j <= i; j++) {
                // s(j...i)子串，如果当前位置的两个字符相等，并且判断s(j + 1.....i - 1)位置是否为回文
                // j + 1 > i - 1 => i - 2 < j <= i
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            System.out.println(minCut(s));
        }
    }
}
