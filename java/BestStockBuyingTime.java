/**
 * Given an array `prices` where `prices[i]` is the price of a given stock on the ith day. Maximize your profit by
 * choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return
 * the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Examples-
 *
 * INPUT: nums = [7,1,5,3,6,4]
 * OUTPUT: 5 because buy on day 1 at $1 then sell on day 4 at $6 = $6 - $1 = $5
 *
 * INPUT: nums = [7,6,4,3,1]
 * OUTPUT: 0 because day 4 is the min price at $1 but there are no more days left to sell
 *
 * INPUT: prices = [2,4,1]
 * OUTPUT: 2 because buy on day 0 at $2 then sell on day 1 at $4 yielding MOST profit even if it's not the min price = $4 - $2 = $2
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
     * Time complexity: O(n) because traversing through entire array only once
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
        System.out.println(maxProfitBruteForce(new int[]{2,4,1})); // 2

        System.out.println();

        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[]{7,6,4,3,1})); // 0
        System.out.println(maxProfitBruteForce(new int[]{2,4,1})); // 2
    }
}
