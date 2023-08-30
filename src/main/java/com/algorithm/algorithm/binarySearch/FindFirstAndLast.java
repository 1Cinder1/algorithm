package com.algorithm.algorithm.binarySearch;

import java.util.Arrays;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/28 9:26
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/28 9:26
 * @updateRemark : 说明本次修改内容
 */

public class FindFirstAndLast {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {5,7,7,8,8,10};
    int target = 12;
    System.out.println(Arrays.stream(solution.searchRange(nums, target)));
  }
  static class Solution {
    public int[] searchRange(int[] nums, int target) {
      int length = nums.length;
      int[] ints = new int[2];
      if (length == 0){
        ints[0] = -1;
        ints[1] = -1;
        return ints;
      }
      int start = findStart(nums, 0, length - 1, target);
      int end = findEnd(nums, 0, length - 1, target);
      ints[0] = start;
      ints[1] = end;
      return ints;
    }
    public int findStart(int[] nums,int start,int end,int target){
      if (start == end){
        return nums[start] == target?start:-1;
      }
      int mid = (start + end) / 2;
      if (nums[mid] >= target) {
        return findStart(nums,start,mid,target);
      }else {
        return findStart(nums,mid+1,end,target);
      }
    }
    public int findEnd(int[] nums,int start,int end,int target){
      if (start == end){
        return nums[start] == target?start:-1;
      }
      int mid = (start + end) / 2+1;
      if (nums[mid] <= target) {
        return findEnd(nums,mid,end,target);
      }else {
        return findEnd(nums,start,mid-1,target);
      }
    }

  }
}
