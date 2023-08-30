package com.algorithm.algorithm.merge;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/27 11:29
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/27 11:29
 * @updateRemark : 说明本次修改内容
 */

public class Intervals {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
    int[][] merge = solution.merge(nums);
    for (int[] ints : merge) {
      System.out.println(ints[0]);
      System.out.println(ints[1]);
      System.out.println();
    }
  }

  static class Solution{
    public int[][] merge(int[][] intervals) {
      int length = intervals.length;
      mergeSort(intervals,0, length -1);
      int[][] result = new int[length][2];
      int pointer = 1;
      result[0] = intervals[0];
      for (int i = 1; i < intervals.length; i++) {
        int[] ints = result[pointer-1];
        if (ints[1] >= intervals[i][0]) {
          ints[1] = Math.max(ints[1],intervals[i][1]);
        }else {
          result[pointer] = intervals[i];
          pointer++;
        }
      }

      return Arrays.copyOfRange(result,0,pointer);
    }

    public void mergeSort(int[][] intervals, int start, int end){
      if (start == end){
        return;
      }
      int mid = (start + end) / 2;
      int length = end - start + 1;
      mergeSort(intervals,start,mid);
      mergeSort(intervals,mid+1,end);
      int start1=start,start2=mid+1;
      int[][] result = new int[length][2];
      int idx=0;
      while (start1<=mid && start2<=end){
        if (intervals[start1][0]<intervals[start2][0]){
          result[idx++] = intervals[start1++];
          continue;
        }
        if (intervals[start1][0]>intervals[start2][0]){
          result[idx++] = intervals[start2++];
        }else {
          if (intervals[start1][1]<intervals[start2][1]){
            result[idx++] = intervals[start1++];
          }else {
            result[idx++] = intervals[start2++];
          }
        }
      }
      while (start1<=mid){
        result[idx++] = intervals[start1++];
      }
      while (start2<=end){
        result[idx++] = intervals[start2++];
      }
      idx = 0;
      for (;idx<length;idx++){
        intervals[start+idx] = result[idx];
      }
    }

  }
}
