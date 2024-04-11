package org.example.week19;

public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyIndex = 0;

        for (int sellIndex = 0; sellIndex < prices.length - 1; sellIndex++) {
            if (prices[sellIndex + 1] < prices[sellIndex]) {
                profit += prices[sellIndex] - prices[buyIndex];
                buyIndex = sellIndex + 1;
            }
        }
        profit += prices[prices.length - 1] - prices[buyIndex];

        return profit;

    }

}
