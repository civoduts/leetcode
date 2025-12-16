package com.civoduts.solution._739;

import java.util.Stack;

public class Solution2 {
  public int[] dailyTemperatures(int[] temperatures) {
    int[] ans = new int[temperatures.length];

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        int prev = stack.pop();
        ans[prev] = i - prev;
      }
      stack.push(i);
    }

    return ans;
  }
}
