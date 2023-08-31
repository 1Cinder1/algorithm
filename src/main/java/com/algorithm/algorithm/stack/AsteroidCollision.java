package com.algorithm.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/31 17:23
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/31 17:23
 * @updateRemark : 说明本次修改内容
 */

public class AsteroidCollision {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] asteroids = {-2,-2,1,-2};
    System.out.println(Arrays.toString(solution.asteroidCollision(asteroids)));
  }
  static class Solution {
    public int[] asteroidCollision(int[] asteroids) {
      ArrayDeque<Integer> integers = new ArrayDeque<>();
      for (int asteroid : asteroids) {
        if (asteroid > 0) {
          integers.push(asteroid);
          continue;
        }
        while (integers.size() >0  &&integers.getFirst() >0 &&integers.getFirst() < Math.abs(asteroid)) {
          integers.poll();
        }
        if (integers.size() == 0 || integers.getFirst() <0){
          integers.push(asteroid);
          continue;
        }
        Integer poll = integers.poll();
        if (poll > Math.abs(asteroid)) {
          integers.push(poll);
        }
      }
      int[] ints = new int[integers.size()];
      int i = 0;
      while (integers.size() != 0) {
        Integer last = integers.pollLast();
        ints[i++] = last;
      }
      return ints;
    }
  }
}
