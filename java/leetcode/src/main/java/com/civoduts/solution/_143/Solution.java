package com.civoduts.solution._143;

public class Solution {
  private static ListNode clone(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (head != null) {
      tail.next = new ListNode(head.val);
      tail = tail.next;
      head = head.next;
    }
    return dummy.next;
  }

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

  private static ListNode merge(
    ListNode list1,
    ListNode list2,
    int count,
    boolean first
  ) {
    if (count == 0)
      return null;
    if (first) {
      list1.next = merge(list1.next, list2, count - 1, false);
      return list1;
    }
    else {
      list2.next = merge(list1, list2.next, count - 1, true);
      return list2;
    }
  }



  private static int size(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  public void reorderList(ListNode head) {
    merge(head, reverse(clone(head)), size(head), true);
  }
}