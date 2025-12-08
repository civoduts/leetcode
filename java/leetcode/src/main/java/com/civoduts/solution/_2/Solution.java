package com.civoduts.solution._2;

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int n1 = l1 != null ? l1.val : 0;
      int n2 = l2 != null ? l2.val : 0;

      int totalSum = n1 + n2 + carry;
      int sumCapped = totalSum % 10;
      carry = totalSum / 10;
      tail.next = new ListNode(sumCapped);

      tail = tail.next;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }

    return dummy.next;
  }
}