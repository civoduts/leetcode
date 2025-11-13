package com.civoduts.solution._261;


class DSU {
  private final int[] parent;
  private final int[] size;
  private int components;

  public DSU(int n) {
    parent = new int[n];
    size = new int[n];
    components = n;
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public int getComponents() {
    return this.components;
  }

  public int find(int node) {
    if (this.parent[node] != node)
      this.parent[node] = find(this.parent[node]);
    return this.parent[node];
  }

  public boolean union(int u, int v) {
    int rootU = find(u), rootV = find(v);
    // already connected; this forms a cycle
    if (rootU == rootV) return false;
    if (this.size[rootU] < this.size[rootV]) {
      this.parent[rootU] = rootV;
      this.size[rootV] += this.size[rootU];
    }
    else {
      this.parent[rootV] = rootU;
      this.size[rootU] += this.size[rootV];
    }
    this.components--;
    return true;
  }
}

public class Solution4 {
  public boolean validTree(int n, int[][] edges) {
    DSU dsu = new DSU(n);
    for (int[] edge : edges) {
      // cycle?
      if (!dsu.union(edge[0], edge[1]))
        return false;
    }

    return dsu.getComponents() == 1;
  }
}

