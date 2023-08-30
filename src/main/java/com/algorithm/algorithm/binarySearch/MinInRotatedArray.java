package com.algorithm.algorithm.binarySearch;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/28 10:31
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/28 10:31
 * @updateRemark : 说明本次修改内容
 */

public class MinInRotatedArray {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {2,1};
    System.out.println(solution.findMin(nums));
  }
  static class Solution {
    public int findMin(int[] nums) {
      int min = findMin(nums, 0, nums.length - 1, nums[0]);
      if (min == nums.length-1){
        if (nums[min] > nums[0]) {
          min = 0;
        }
      }
      return nums[min];
    }
    public int findMin(int[] nums,int start,int end,int target) {
      if (start == end){
        return start;
      }
      int mid = (start + end) / 2;
      if (nums[mid] >= target) {
        
        return findMin(nums,mid+1,end,target);
      }else {
        return findMin(nums,start,mid,target);
      }
    }
  }
}
