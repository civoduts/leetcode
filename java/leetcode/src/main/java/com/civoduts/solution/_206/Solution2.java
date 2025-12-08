package com.civoduts.solution._206;

public class Solution2 {
  private static ListNode reverse(ListNode prev, ListNode curr) {
    if (curr == null)
      return prev;

    ListNode next = curr.next;
    curr.next = prev;
    return reverse(curr, next);
  }

  public ListNode reverseList(ListNode head) {
    return reverse(null, head);
  }
}