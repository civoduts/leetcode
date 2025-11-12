package com.civoduts.solution._261;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

  private boolean hasCycle(
    int node,
    int cameFrom,
    List<List<Integer>> graph,
    boolean[] visited
  ) {
    if (visited[node])
      return true;

    visited[node] = true;
    for (int nei : graph.get(node)) {
      if (nei == cameFrom)
        continue;
      if (hasCycle(nei, node, graph, visited))
        return true;
    }

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

    boolean[] visited = new boolean[n];
    if (hasCycle(0, -1, graph, visited))
      return false;

    // disconnected?
    for (boolean vis : visited) {
      if (!vis)
        return false;
    }

    return true;
  }
}
