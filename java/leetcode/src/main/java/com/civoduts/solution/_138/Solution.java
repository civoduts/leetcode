package com.civoduts.solution._138;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public Node copyRandomList(Node head) {
    if (head == null)
      return null;

    // init map
    Map<Node, Node> cloneMap = new HashMap<>();
    for (Node original = head; original != null; original = original.next) {
      cloneMap.put(original, new Node(original.val));
    }

    // update next, random nodes
    for (Node original = head; original != null; original = original.next) {
      Node clone = cloneMap.get(original);
      if (original.next != null)
        clone.next = cloneMap.get(original.next);
      if (original.random != null)
        clone.random = cloneMap.get(original.random);
    }

    return cloneMap.get(head);
  }
}