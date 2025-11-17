package com.civoduts.solution._2;

public class Solution2 {
  static ListNode add(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0)
      return null;

    int sum = 0;
    if (l1 != null) {
      sum += l1.val;
      l1 = l1.next;
    }
    if (l2 != null) {
      sum += l2.val;
      l2 = l2.next;
    }
    return new ListNode(sum % 10, add(l1, l2, sum / 10));
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return add(l1, l2, 0);
  }
}