package com.civoduts.solution._347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>(nums.length);
    for (int n : nums)
      freq.merge(n, 1, Integer::sum);

    List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
    for (int i = 0; i < nums.length + 1; i++) {
      buckets.add(new ArrayList<>());
    }

    for (Map.Entry<Integer, Integer> mapper : freq.entrySet()) {
      Integer f = mapper.getValue();
      Integer num = mapper.getKey();
      buckets.get(f).add(num);
    }

    int[] ans = new int[k];
    for (int i = nums.length; i > 0 && k > 0; i--) {
      for (int j = 0; j < buckets.get(i).size() && k > 0; j++) {
        ans[ans.length - k] = buckets.get(i).get(j);
        k--;
      }
    }

    return ans;
  }
}
