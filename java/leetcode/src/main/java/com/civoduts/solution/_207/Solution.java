package com.civoduts.solution._207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private static final int UNVISITED = 0, VISITING = 1, DONE = 2;

  private boolean hasCycleFrom(int course, Map<Integer, List<Integer>> graph, int[] state) {
    if (state[course] == VISITING) return true;
    if (state[course] == DONE) return false;

    state[course] = VISITING;
    if (graph.containsKey(course)) {
      for (int prereq : graph.get(course)) {
        if (!hasCycleFrom(prereq, graph, state)) return true;
      }
    }
    state[course] = DONE;
    return false;
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
      if (state[c] == UNVISITED && !hasCycleFrom(c, graph, state)) {
        return false;
      }
    }

    return true;
  }
}