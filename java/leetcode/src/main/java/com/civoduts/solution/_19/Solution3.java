package com.civoduts.solution._19;

public class Solution3 {
  // one pass
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);

    ListNode slow = dummy, fast = dummy;
    // move fast n+1 nodes ahead
    for (int i = 0; i <= n; i++) fast = fast.next;

    // move until the end of the list is hit
    // slow is n+1 nodes behind the end of the list
    // i.e. slow is one position behind the element
    // to be removed
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
  }
}