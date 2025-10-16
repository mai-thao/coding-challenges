package main

import (
    "fmt"
    "math"
)

/*
 * Given an array `prices` where `prices[i]` is the price of a given stock on the ith day. Maximize your profit by
 * choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return
 * the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Time complexity: O(n) because traversing through entire array only once
 * Space complexity: O(1) because not using extra datasets
 */
func maxProfit(prices []int) int {
    minProfit := math.MaxInt
    maxProfit := 0
    for _, price := range prices {
        minProfit = int(math.Min(float64(price), float64(minProfit)))
        profit := price - minProfit
        maxProfit = int(math.Max(float64(profit), float64(maxProfit)))
    }
    return maxProfit
}

func main() {
    fmt.Println(maxProfit([]int{7,1,5,3,6,4}))  // 5
    fmt.Println(maxProfit([]int{7,6,4,3,1}))    // 0
    fmt.Println(maxProfit([]int{2,4,1}))        // 2
}
