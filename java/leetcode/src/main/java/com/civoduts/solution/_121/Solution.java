package com.civoduts.solution._121;

public class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = Integer.MAX_VALUE;

    for (int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      }
      else {
        maxProfit = Math.max(maxProfit, price - minPrice);
      }
    }

    return maxProfit;
  }
}
