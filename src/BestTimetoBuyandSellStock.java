/**
 * Created by apple on 17/4/3.
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 解题思路：
 只能进行一次交易。
 当前元素与上一个元素，做差值。然后将原问题转化为 子数组中和的最大值问题
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int sum = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {
            sum = (prices[i] - prices[i - 1]) + (sum > 0 ? sum : 0);
            max = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String[] args) {
        BestTimetoBuyandSellStock my = new BestTimetoBuyandSellStock();
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(my.maxProfit(arr));
    }
}
