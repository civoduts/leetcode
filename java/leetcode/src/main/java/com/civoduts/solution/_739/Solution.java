package com.civoduts.solution._739;

import java.util.Stack;

public class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int[] ans = new int[temperatures.length];

    Stack<Integer> stack = new Stack<>();
    for (int i = temperatures.length - 1; i >= 0; i--) {
      int temp = temperatures[i];
      while (!stack.isEmpty() && temperatures[stack.peek()] <= temp)
        stack.pop();

      if (!stack.isEmpty()) {
        ans[i] = stack.peek() - i;
      }

      stack.push(i);
    }

    return ans;
  }
}
