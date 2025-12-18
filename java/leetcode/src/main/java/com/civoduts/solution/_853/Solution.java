package com.civoduts.solution.lol._853;

import java.util.Arrays;

public class Solution {
  static final class Car {
    final int position;
    final int speed;

    public Car(int position, int speed) {
      this.position = position;
      this.speed = speed;
    }
  }

  public int carFleet(int target, int[] position, int[] speed) {
    Car[] cars = new Car[position.length];
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(position[i], speed[i]);
    }

    Arrays.sort(cars, (car1, car2) -> Integer.compare(car2.position, car1.position));

    double prevTTF = Double.NEGATIVE_INFINITY;
    int groups = 0;
    for (Car car : cars) {
      double ttf = (double) (target - car.position) / car.speed;
      if (ttf > prevTTF) {
        prevTTF = ttf;
        groups++;
      }
    }

    return groups;
  }
}
