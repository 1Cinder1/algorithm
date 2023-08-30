package com.algorithm.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/30 20:08
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/30 20:08
 * @updateRemark : 说明本次修改内容
 */

public class DailyTemperatures {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] temperatures = {73,74,75,71,69,72,76,73};
    System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
  }
  static class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      ArrayDeque<BindIndex> integers = new ArrayDeque<>();
      int[] ints = new int[temperatures.length];
      for (int i = 0; i < temperatures.length; i++) {
        BindIndex bindIndex = new BindIndex();
        bindIndex.index = i;
        bindIndex.val = temperatures[i];
        if (integers.size() == 0){
          integers.push(bindIndex);
          continue;
        }
        try {
          while (temperatures[i] > integers.getFirst().val) {
            BindIndex poll = integers.poll();
            ints[poll.index] = i- poll.index;
          }
        }catch (Exception e) {

        }
        integers.push(bindIndex);
      }
      while (integers.size() != 0){
        BindIndex bindIndex = integers.pollLast();
        ints[bindIndex.index] = 0;
      }
      return ints;
    }
    class BindIndex {
      private int index;

      private int val;
    }
  }
}
