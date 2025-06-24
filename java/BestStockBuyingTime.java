/**
 * Given an array `prices` where `prices[i]` is the price of a given stock on the ith day. Maximize your profit by
 * choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return
 * the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestStockBuyingTime {
    /**
     * Brute-force solution. Good for small arrays but for large arrays, will throw `Time Limit Exceeded`!
     *
     * Time complexity: O(n^2) because nested-loop loops through every possible combinations in array
     * Space complexity: O(1) because not using extra datasets
     */
    public static int maxProfitBruteForce(int[] prices) {
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

    /**
     * Time complexity: O(n) because traversing through entire array once
     * Space complexity: O(1) because not using extra datasets
     */
    public static int maxProfit(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price: prices) {
            if (price < minProfit) {
                minProfit = price;
            }
            if ((price - minProfit) > maxProfit) {
                maxProfit = price - minProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitBruteForce(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(maxProfitBruteForce(new int[]{7,6,4,3,1})); // 0

        System.out.println();

        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[]{7,6,4,3,1})); // 0
    }
}
