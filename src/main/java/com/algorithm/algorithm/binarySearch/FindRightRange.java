package com.algorithm.algorithm.binarySearch;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/30 16:59
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/30 16:59
 * @updateRemark : 说明本次修改内容
 */

public class FindRightRange {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] intervals = {
      {3,4},
      {2,3},
      {1,2}
    };
    int[] rightInterval = solution.findRightInterval(intervals);
    for (int i : rightInterval) {
      System.out.println(i);
    }
  }
  static class Solution {
    public int[] findRightInterval(int[][] intervals) {
      sort(intervals,0,intervals.length-1);
      return null;
    }
    public void sort(int[][] ints,int start,int end){
      if (start == end){
        return;
      }
      int front = start,tail=end;
      int[] benchmark = ints[start];
      while (front < tail) {
        while (front < tail &&ints[front][0] < benchmark[0]) {
          front++;
        }
        while (front < tail && ints[tail][0] >= benchmark[0]) {
          tail--;
        }
        if (front < tail) {
          int[] temp = ints[front];
          ints[front++] = ints[tail];
          ints[tail--] = temp;
        }
      }
      sort(ints,0,front);
      sort(ints,front+1,end);
    }
  }
}
