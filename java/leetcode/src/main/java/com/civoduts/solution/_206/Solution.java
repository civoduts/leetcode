package com.civoduts.solution._206;

public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null, current = head;
    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }
}