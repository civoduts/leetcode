class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        min_price = float("inf")
        max_profit = 0

        for p in prices:
            if min_price > p:
                min_price = p
            else:
                profit = p - min_price
                if max_profit < profit:
                    max_profit = profit
        return max_profit
