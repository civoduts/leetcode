class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        i, j = 0, 1
        max_profit = 0
        while j < len(prices):
            max_profit = max(max_profit, prices[j] - prices[i])

            if prices[i] > prices[j]:
                i = j
            j += 1

        return max_profit
