package com.civoduts.solution._323;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private void visitGraph(
    int node,
    List<List<Integer>> adj,
    boolean[] visited
  ) {
    visited[node] = true;
    for (int nei : adj.get(node)) {
      // don't go into a cycle
      if (!visited[nei])
        visitGraph(nei, adj, visited);
    }
  }

  public int countComponents(int n, int[][] edges) {
    if (n <= 1 || edges.length == 0)
      return n;

    List<List<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    boolean[] visited = new boolean[n];
    int components = 0;
    for (int node = 0; node < n; node++) {
      if (!visited[node]) {
        components++;
        visitGraph(node, adj, visited);
      }
    }

    return components;
  }
}
