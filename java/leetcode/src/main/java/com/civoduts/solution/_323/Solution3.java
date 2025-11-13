package com.civoduts.solution._323;

class DSU {
  private final int[] parent, size;
  private int components;

  public int getComponents() {
    return this.components;
  }

  public DSU(int n) {
    this.parent = new int[n];
    this.size = new int[n];
    this.components = n;

    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public int find(int node) {
    if (parent[node] != node)
      parent[node] = find(parent[node]);
    return this.parent[node];
  }

  public void union(int u, int v) {
    int rootU = find(u);
    int rootV = find(v);

    if (rootU == rootV) return;

    if (this.size[rootU] < this.size[rootV]) {
      this.parent[rootU] = rootV;
      this.size[rootV] += this.size[rootU];
    }
    else {
      this.parent[rootV] = rootU;
      this.size[rootU] += this.size[rootV];
    }

    components--;
  }

}

public class Solution3 {
  public int countComponents(int n, int[][] edges) {
    DSU dsu = new DSU(n);
    for (int[] edge : edges) {
      dsu.union(edge[0], edge[1]);
    }

    return dsu.getComponents();
  }
}
