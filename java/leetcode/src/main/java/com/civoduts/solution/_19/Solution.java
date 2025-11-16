package com.civoduts.solution._19;

public class Solution {
  private static ListNode reverse(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  // brute-force af
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null)
      return head;
    if (n == 1)
      return reverse(reverse(head).next);

    head = reverse(head);
    ListNode prev = head;
    for (int i = 1; i < n - 1; i++) {
      prev = prev.next;
    }
    prev.next = prev.next.next;

    return reverse(head);
  }
}