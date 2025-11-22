package com.civoduts.solution._146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private static class ListNode {
    final int key;
    int value;
    ListNode prev, next;

    public ListNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private ListNode head, tail;
  private final Map<Integer, ListNode> cache;
  private final int maxCap;

  public LRUCache(int capacity) {
    head = tail = null;
    cache = new HashMap<>();
    maxCap = capacity;
  }

  public int get(int key) {
    ListNode item = cache.get(key);
    if (item == null)
      return -1;

    moveToHead(item);
    return item.value;
  }

  public void put(int key, int value) {
    ListNode item = cache.get(key);
    if (item != null) {
      item.value = value;
      moveToHead(item);
      return;
    }

    if (cache.size() == maxCap) {
      cache.remove(tail.key); // evict least used
      removeTail();
    }

    ListNode newItem = new ListNode(key, value);
    addToHead(newItem);
    cache.put(key, newItem);
  }

  private void removeTail() {
    if (tail == null)
      return;

    if (tail.prev != null) {
      tail.prev.next = null;
      tail = tail.prev;
    }
    else { // if maxCap = 1
      head = null; // tail = head case; set the head and the tail below
      tail = null;
    }
  }

  private void moveToHead(ListNode item) {
    if (item == head)
      return;
    detach(item);
    addToHead(item);
  }

  private void detach(ListNode item) {
    ListNode oldPrev = item.prev, oldNext = item.next;

    if (oldPrev != null)
      oldPrev.next = oldNext;
    else // we were head
      head = oldNext;

    if (oldNext != null)
      oldNext.prev = oldPrev;
    else // we were tail
      tail = oldPrev;

    item.prev = null;
    item.next = null;
  }

  private void addToHead(ListNode item) {
    item.next = head;
    item.prev = null;
    if (head != null)
      head.prev = item;
    head = item;
    if (tail == null)
      tail = item;
  }
}
