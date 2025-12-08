package com.civoduts.solution._347;

import java.util.*;

public class Solution2 {
  record Element(int number, int frequency) {
  }

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>(nums.length);
    for (int n : nums)
      freq.merge(n, 1, Integer::sum);

    PriorityQueue<Element> q = new PriorityQueue<>(Comparator.comparingInt(e -> -e.frequency()));
    for (Map.Entry<Integer, Integer> mapper : freq.entrySet()) {
      q.offer(new Element(mapper.getKey(), mapper.getValue()));
    }

    int[] ans = new int[k];
    while (!q.isEmpty() && k-- > 0) {
      ans[k] = q.poll().number();
    }

    return ans;
  }
}
