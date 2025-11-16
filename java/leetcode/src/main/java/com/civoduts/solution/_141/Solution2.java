package com.civoduts.solution._141;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
  public boolean hasCycle(ListNode head) {
    Set<ListNode> seen = new HashSet<>();
    while (head != null) {
      if (seen.contains(head))
        return true;
      seen.add(head);
      head = head.next;
    }
    return false;
  }
}