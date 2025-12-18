package com.civoduts.solution._121;

public class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int bestPrice = Integer.MAX_VALUE;

    for (int price : prices) {
      int profit = price - bestPrice;
      maxProfit = Math.max(maxProfit, profit);
      bestPrice = Math.min(bestPrice, price);
    }

    return maxProfit;
  }
}
