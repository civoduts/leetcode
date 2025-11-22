package com.civoduts.solution._146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
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
    return item.getValue();
  }

  public void put(int key, int value) {
    ListNode item = cache.get(key);
    if (item != null) {
      item.setValue(value);
      moveToHead(item);
      return;
    }

    if (cache.size() == maxCap) {
      cache.remove(tail.getKey()); // evict least used
      removeTail();
    }

    ListNode newItem = new ListNode(key, value);
    addToHead(newItem);
    cache.put(key, newItem);
  }

  private void removeTail() {
    if (tail == null)
      return;

    if (tail.getPrev() != null) {
      tail.getPrev().setNext(null);
      tail = tail.getPrev();
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
    ListNode oldPrev = item.getPrev(), oldNext = item.getNext();

    if (oldPrev != null)
      oldPrev.setNext(oldNext);
    else // we were head
      head = oldNext;

    if (oldNext != null)
      oldNext.setPrev(oldPrev);
    else // we were tail
      tail = oldPrev;

    item.setPrev(null);
    item.setNext(null);
  }

  private void addToHead(ListNode item) {
    item.setNext(head);
    item.setPrev(null);
    if (head != null)
      head.setPrev(item);
    head = item;
    if (tail == null)
      tail = item;
  }
}

class ListNode {
  private final int key;
  private int value;
  private ListNode prev, next;

  public Integer getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public ListNode getPrev() {
    return prev;
  }

  public void setPrev(ListNode prev) {
    this.prev = prev;
  }

  public ListNode(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
