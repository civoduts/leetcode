package com.civoduts.solution._210;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>(numCourses);
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    int[] indegrees = new int[numCourses];
    for (int[] pair : prerequisites) {
      int course = pair[0];
      int prereq = pair[1];

      adj.get(prereq).add(course);
      indegrees[course]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < indegrees.length; i++) {
      if (indegrees[i] == 0)
        queue.offer(i);
    }

    int[] order = new int[numCourses];
    int done = 0;
    while (!queue.isEmpty()) {
      int course = queue.poll();
      order[done++] = course;

      for (Integer nei : adj.get(course)) {
        if (--indegrees[nei] == 0)
          queue.offer(nei);
      }
    }

    return done == numCourses ? order : new int[0];
  }
}