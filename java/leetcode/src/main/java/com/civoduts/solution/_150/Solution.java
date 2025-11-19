package com.civoduts.solution._150;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  int add(int a, int b) {return a + b;}

  int sub(int a, int b) {return a - b;}

  int mul(int a, int b) {return a * b;}

  int div(int a, int b) {return a / b;}

  int op(String token, Deque<Integer> stack) {
    return switch (token) {
      case "+" -> {
        int second = stack.pop();
        int first = stack.pop();
        yield add(first, second);
      }
      case "-" -> {
        int second = stack.pop();
        int first = stack.pop();
        yield sub(first, second);
      }
      case "*" -> {
        int second = stack.pop();
        int first = stack.pop();
        yield mul(first, second);
      }
      case "/" -> {
        int second = stack.pop();
        int first = stack.pop();
        yield div(first, second);
      }
      default -> Integer.parseInt(token);
    };
  }

  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String token : tokens) {
      stack.push(op(token, stack));
    }
    return stack.pop();
  }
}
