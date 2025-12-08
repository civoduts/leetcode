package com.civoduts.solution._207;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private static final int UNVISITED = 0, VISITING = 1, DONE = 2;

  private boolean hasCycleFrom(int course, List<Integer>[] graph, int[] state) {
    if (state[course] == VISITING) return true;
    if (state[course] == DONE) return false;

    state[course] = VISITING;
    List<Integer> prereqs = graph[course];
    if (prereqs != null) {
      for (int p : prereqs) {
        if (hasCycleFrom(p, graph, state)) return true;
      }
    }
    state[course] = DONE;
    return false;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = new ArrayList[numCourses];
    for (int[] prerequisite : prerequisites) {
      int course = prerequisite[0], prereq = prerequisite[1];

      if (graph[course] == null) graph[course] = new ArrayList<>();
      graph[course].add(prereq);
    }

    int[] state = new int[numCourses];
    for (int c = 0; c < numCourses; c++) {
      if (state[c] == UNVISITED && hasCycleFrom(c, graph, state)) {
        return false;
      }
    }

    return true;
  }
}