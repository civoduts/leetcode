package com.civoduts.solution._684;

class DSU {
  private final int[] parent, size;

  public DSU(int n) {
    this.parent = new int[n + 1];
    this.size = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      this.parent[i] = i;
      this.size[i] = 1;
    }
  }

  public int find(int node) {
    if (parent[node] != node)
      parent[node] = find(parent[node]);
    return parent[node];
  }

  public boolean union(int u, int v) {
    int rootU = find(u), rootV = find(v);

    if (rootU == rootV) return false;

    if (this.size[rootU] < this.size[rootV]) {
      this.parent[rootU] = rootV;
      this.size[rootV] += this.size[rootU];
    }
    else {
      this.parent[rootV] = rootU;
      this.size[rootU] += this.size[rootV];
    }

    return true;
  }
}

public class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    DSU dsu = new DSU(n);

    for (int[] edge : edges) {
      if (!dsu.union(edge[0], edge[1]))
        return new int[]{edge[0], edge[1]};
    }

    return new int[]{};
  }
}