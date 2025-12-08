package com.civoduts.solution._143;

public class Solution2 {
  static ListNode reverseList(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  static ListNode findMid(ListNode head) {
    if (head == null)
      return null;

    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  static void mergeLists(ListNode list1, ListNode list2) {
    while (list1 != null && list2 != null) {
      ListNode tmp1 = list1.next;
      ListNode tmp2 = list2.next;

      list1.next = list2;
      list2.next = tmp1;
      list1 = tmp1;
      list2 = tmp2;
    }
  }

  public void reorderList(ListNode head) {
    if (head == null || head.next == null)
      return;

    ListNode mid = findMid(head);
    ListNode second = reverseList(mid.next);
    mid.next = null;

    // first: head, head.next, ... , mid, null
    // second: tail, tail.prev, ..., mid.next, null
    mergeLists(head, second);
  }
}