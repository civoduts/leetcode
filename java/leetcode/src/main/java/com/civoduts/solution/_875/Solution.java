package com.civoduts.solution._875;

public class Solution {
  private long duration(int[] piles, int candidate) {
    long duration = 0;
    for (int p : piles) {
      duration += (long) Math.ceil((double) p / candidate);
    }
    return duration;
  }

  private int max(int[] piles) {
    int max = Integer.MIN_VALUE;
    for (int p : piles) {
      max = Math.max(max, p);
    }
    return max;
  }

  public int minEatingSpeed(int[] piles, int h) {
    int low = 1, high = max(piles);
    int best = high;
    while (low <= high) {
      int candidate = low + (high - low) / 2;
      long totalTime = duration(piles, candidate);

      if (totalTime <= h) { // eating too fast
        best = Math.min(best, candidate);
        high = candidate - 1; // slow down we got time
      }
      else { // eating too slow
        low = candidate + 1; // hurry up
      }
    }

    return best;
  }
}
