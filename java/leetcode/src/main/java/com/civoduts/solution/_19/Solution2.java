package com.civoduts.solution._19;

public class Solution2 {
  private static int length(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  // two-pass
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int len = length(head);
    int steps = len - n; // steps from dummy before the one to delete
    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;

    for (int i = 0; i < steps; i++) {
      prev = prev.next;
    }
    prev.next = prev.next.next;
    return dummy.next;
  }
}
