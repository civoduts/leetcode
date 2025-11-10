package com.civoduts.solution._207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private final int UNVISITED = 0, VISITING = 1, DONE = 2;

  private boolean dfs(int course, Map<Integer, List<Integer>> graph, int[] state) {
    if (state[course] == VISITING) return false;
    if (state[course] == DONE) return true;

    state[course] = VISITING;
    if (graph.containsKey(course)) {
      for (int prereq : graph.get(course)) {
        if (!dfs(prereq, graph, state)) return false;
      }
    }
    state[course] = DONE;
    return true;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] state = new int[numCourses];

    for (int[] prerequisite : prerequisites) {
      int course = prerequisite[0];
      int prereq = prerequisite[1];

      if (!graph.containsKey(course)) {
        graph.put(course, new ArrayList<>());
      }
      graph.get(course).add(prereq);
    }

    for (int c = 0; c < numCourses; c++) {
      if (state[c] == UNVISITED && !dfs(c, graph, state)) {
        return false;
      }
    }

    return true;
  }
}