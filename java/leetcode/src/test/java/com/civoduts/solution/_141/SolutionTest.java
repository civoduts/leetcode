package com.civoduts.solution._141;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {
  private Solution solution;

  private ListNode listFromArray(int[] values) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    for (int v : values) {
      tail.next = new ListNode(v);
      tail = tail.next;
    }
    return dummy.next;
  }

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void hasCycle_multipleNodesNoCycle_returnsFalse() {
    int[] nodes = new int[]{
      -21, 10, 17, 8, 4,
      26, 5, 35, 33, -7,
      -16, 27, -12, 6, 29,
      -12, 5, 9, 20, 14,
      14, 2, 13, -24, 21,
      23, -21, 5
    };
    assertFalse(solution.hasCycle(listFromArray(nodes)));
  }

  @Test
  void hasCycle_multipleSameNodesNoCycle_returnsFalse() {
    int[] nodes = new int[]{
      1, 2, 3, 4, 5,
      6, 7, 4, 5, 6,
      7, 4, 5, 6, 7,
      4, 5, 6, 7, 4,
      5, 6, 7, 4, 5,
      6, 7, 4, 5, 6,
      7, 4, 5, 6, 7
    };
    assertFalse(solution.hasCycle(listFromArray(nodes)));
  }
}