/**
 * Given an array `prices` where `prices[i]` is the price of a given stock on the ith day. Maximize your profit by
 * choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return
 * the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestStockBuyingTime {
    public static int maxProfit(int[] prices) {
        int maxProfit = -1;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > 0) {
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
        }
        if (maxProfit > -1) {
            return maxProfit;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[]{7,6,4,3,1})); // 0
    }
}
