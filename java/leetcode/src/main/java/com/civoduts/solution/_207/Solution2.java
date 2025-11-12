package com.civoduts.solution._207;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>(numCourses);
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    int[] indegrees = new int[numCourses];
    for (int[] pair : prerequisites) {
      int course = pair[0];
      int prereq = pair[1];

      adj.get(prereq).add(course);
      indegrees[course] += 1;
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < indegrees.length; i++) {
      if (indegrees[i] == 0)
        queue.offer(i);
    }

    int finished = 0;
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      finished++;

      for (Integer next : adj.get(curr)) {
        if (--indegrees[next] == 0)
          queue.offer(next);
      }
    }

    return finished == numCourses;
  }
}