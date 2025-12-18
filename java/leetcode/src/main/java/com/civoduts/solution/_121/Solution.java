package com.civoduts.solution._121;

public class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;

    for (int price : prices) {
      int profit = price - minPrice;
      maxProfit = Math.max(maxProfit, profit);
      minPrice = Math.min(minPrice, price);
    }

    return maxProfit;
  }
}
