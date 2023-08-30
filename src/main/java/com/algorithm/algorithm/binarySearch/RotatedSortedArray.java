package com.algorithm.algorithm.binarySearch;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/27 20:06
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/27 20:06
 * @updateRemark : 说明本次修改内容
 */

public class RotatedSortedArray {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {1};
    int target = 4;
    System.out.println(solution.search(nums, target));
  }
  static class Solution {
    public int search(int[] nums, int target) {
      int k =0;
      int length = nums.length;
      for (int i = 0; i < length -1; i++) {
        if (nums[i]>nums[i+1]) {
          k = i+1;
          break;
        }
      }
      if (nums[length-1] >= target) {
        return findIndex(nums,k,length-1,target);
      }else {
        if (k == 0){
          return -1;
        }else {
          return findIndex(nums,0,k-1,target);
        }
      }
    }
    public int findIndex(int[] nums,int start,int end,int target){
      if (start == end){
        return nums[start] == target?start:-1;
      }
      int mid = (start + end) / 2;
      if (nums[mid]>=target) {
        return findIndex(nums,start,mid,target);
      }else {
        return findIndex(nums,mid+1,end,target);
      }
    }
  }
}
