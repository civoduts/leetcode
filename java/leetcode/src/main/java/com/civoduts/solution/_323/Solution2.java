package com.civoduts.solution._323;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

  private void visitGraph(Queue<Integer> queue, List<List<Integer>> adj, boolean[] visited) {
    while (!queue.isEmpty()) {
      int node = queue.poll();

      for (int nei : adj.get(node)) {
        if (!visited[nei]) {
          visited[nei] = true;
          queue.offer(nei);
        }
      }
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
    Queue<Integer> queue = new ArrayDeque<>();

    int components = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        components++;
        visited[i] = true;
        queue.offer(i);
        visitGraph(queue, adj, visited);
      }
    }

    return components;
  }
}
