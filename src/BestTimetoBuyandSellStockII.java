/**
 * Created by apple on 17/4/3.
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

解题思路：
 可以多次交易，局部最小值，局部最大值。贪心算法
 便利一遍所有的元素，复杂度： O(N)
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int i = 0, profit = 0;
        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            int min = prices[i++];
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            profit += i < prices.length ? prices[i] - min : 0;
        }
        return profit;
    }
    public static void main(String[] args) {
        BestTimetoBuyandSellStockII my = new BestTimetoBuyandSellStockII();
        int[] arr = {1};
        System.out.println(my.maxProfit(arr));
    }
}
