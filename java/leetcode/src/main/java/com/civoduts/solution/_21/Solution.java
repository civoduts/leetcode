package com.civoduts.solution._21;

public class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    if (list2 == null)
      return list1;

    ListNode head = null, prev = null, curr = null;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        curr = list1;
        list1 = list1.next;
      }
      else {
        curr = list2;
        list2 = list2.next;
      }

      if (head == null) head = curr;
      if (prev != null) prev.next = curr;
      prev = curr;
    }

    curr.next = list1 != null ? list1 : list2;
    return head;
  }
}