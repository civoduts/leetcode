package com.civoduts.solution._287;

public class Solution {
  // The array has length n + 1 and all values are in [1, n], so at least one value must repeat.
  // We can view the array as a linked list where index i points to index nums[i]. Because
  // values never point to 0, index 0 lies outside the cycle unless nums[0] itself is the duplicate.
  //
  // We run Floyd's cycle-finding algorithm starting from nums[0]. Slow moves one step at a time
  // and fast moves two steps at a time (slow = nums[slow], fast = nums[nums[fast]]). They will
  // eventually meet somewhere inside the cycle.
  //
  // Once they meet, we start a second pointer at nums[0] and move it together with slow, both
  // taking one step per iteration. The point where they meet again is the entrance to the cycle.
  // That entrance corresponds to the duplicate value, so we return it.
  //
  // Summary: slow and fast meet inside the cycle; starting a new slow pointer from nums[0] and one
  // from the meeting point makes them meet at the cycle entrance, which is the duplicate.
  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    int slow2 = nums[0];
    while (slow != slow2) {
      slow = nums[slow];
      slow2 = nums[slow2];
    }

    return slow;
  }
}
