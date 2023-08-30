package com.algorithm.algorithm.binarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/28 8:31
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/28 8:31
 * @updateRemark : 说明本次修改内容
 */

public class InsertRange {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] intervals = {
      {1,5}
    };
    int[] newInterval={6,8};
    int[][] insert = solution.insert(intervals, newInterval);
    System.out.println(insert);
  }
  static class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      int originLength = intervals.length;
      if (originLength == 0){
        int[][] ints = new int[1][2];
        ints[0] = newInterval;
        return ints;
      }
      int targetIndex = findTargetIndex(intervals, 0, originLength - 1, newInterval[0]);
      int preIndex = findTargetIndex(intervals, targetIndex, originLength - 1, newInterval[1]);
      int from = targetIndex,to=preIndex+1;
      if (intervals[targetIndex][1] >= newInterval[0]) {
        // need to merge two range
        if (intervals[preIndex][0] > newInterval[1]) {
          to=preIndex;
        }
      }else {
        from = targetIndex+1;
        if (intervals[preIndex][0] > newInterval[1]) {
          to=preIndex;
        }
      }
      if (from == to){
        int[][] ints = new int[originLength+1][2];
        for (int i = 0; i < from; i++) {
          ints[i] = intervals[i];
        }
        ints[from] = newInterval;
        for (int i = from+1; i < originLength+1; i++) {
          ints[i] = intervals[i-1];
        }
        return ints;
      }
      int[] newRange ={Math.min(intervals[from][0],newInterval[0]),Math.max(intervals[to-1][1],newInterval[1])};
      int length = from+ originLength -to+1;
      int[][] ints = new int[length][2];
      for (int i = 0; i < from; i++) {
        ints[i] = intervals[i];
      }
      ints[from] = newRange;
      for (int i = from+1; i < length; i++) {
        ints[i] = intervals[i+to-from-1];
      }
      return ints;
    }
    public int findTargetIndex(int[][] intervals,int start,int end,int target){
      if (start == end){
        return start;
      }
      int mid = (start + end) / 2;
      if (intervals[mid+1][0]==target) {
        return mid+1;
      }
      if (intervals[mid+1][0] < target){
        return findTargetIndex(intervals,mid+1,end,target);
      }else {
        return findTargetIndex(intervals, start, mid, target);
      }

    }
  }

}
