package com.civoduts.solution._133;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private Node clone(Node node, Map<Integer, Node> map) {
    if (node == null) {
      return null;
    }

    Node cloned = map.get(node.val);
    if (cloned != null) {
      return cloned;
    }

    cloned = new Node(node.val);
    map.put(cloned.val, cloned);
    for (Node nei : node.neighbors) {
      cloned.neighbors.add(clone(nei, map));
    }
    return cloned;
  }

  public Node cloneGraph(Node node) {
    return clone(node, new HashMap<>());
  }
}
