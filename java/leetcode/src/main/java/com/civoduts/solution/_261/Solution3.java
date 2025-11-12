package com.civoduts.solution._261;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution3 {

  record Node(int value, int parent) {}

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
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(new Node(0, -1));

    int processed = 0;
    while (!queue.isEmpty()) {
      Node node = queue.poll();

      if (visited[node.value()])
        return false;

      visited[node.value()] = true;
      processed++;
      for (int nei : graph.get(node.value())) {
        if (nei == node.parent())
          continue;
        queue.offer(new Node(nei, node.value()));
      }
    }

    return processed == n;
  }
}
