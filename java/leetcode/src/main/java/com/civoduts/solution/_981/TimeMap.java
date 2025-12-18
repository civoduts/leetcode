package com.civoduts.solution._981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
  static class TimeSeries {
    final String value;
    final int timestamp;

    public TimeSeries(String value, int timestamp) {
      this.value = value;
      this.timestamp = timestamp;
    }
  }

  private final Map<String, List<TimeSeries>> store;

  public TimeMap() {
    this.store = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    List<TimeSeries> ts = store.computeIfAbsent(key, _ -> new ArrayList<>());
    ts.add(new TimeSeries(value, timestamp));
  }

  public String get(String key, int timestamp) {
    List<TimeSeries> ts = store.get(key);
    if (ts == null) {
      return "";
    }

    int low = 0, high = ts.size() - 1;
    String ans = "";
    while (low <= high) {
      int mid = low + (high - low) / 2;
      TimeSeries data = ts.get(mid);

      if (data.timestamp <= timestamp) {
        ans = data.value;
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }

    return ans;
  }
}
