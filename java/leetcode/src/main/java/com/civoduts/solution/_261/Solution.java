package com.civoduts.solution._261;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private static final int UNVISITED = 0, VISITING = 1, DONE = 2;

  private boolean hasCycle(
    int node,
    int cameFrom,
    List<List<Integer>> graph,
    int[] state
  ) {
    if (state[node] == VISITING) return true;
    if (state[node] == DONE) return false;

    state[node] = VISITING;
    for (int nei : graph.get(node)) {
      if (nei == cameFrom)
        continue;
      if (hasCycle(nei, node, graph, state))
        return true;
    }
    state[node] = DONE;

    return false;
  }

  public boolean validTree(int n, int[][] edges) {
    if (n == 0)
      return false;
    if (edges.length != n - 1)
      return false;

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    int[] state = new int[n];
    for (int node = 0; node < n; node++) {
      boolean isDisconnected = node > 0 && state[node] == UNVISITED;
      if (isDisconnected || hasCycle(node, -1, graph, state))
        return false;
    }

    return true;
  }
}
