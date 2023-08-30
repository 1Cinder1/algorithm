package com.algorithm.algorithm.binarySearch;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/29 8:50
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/29 8:50
 * @updateRemark : 说明本次修改内容
 */

public class FindDuplicateNum {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {1,3,4,2,2};
    System.out.println(solution.findDuplicate(nums));
  }
  static class Solution {
    public int findDuplicate(int[] nums) {
      int length = nums.length;
      int[] ints = new int[length];
      int result = 0;
      for (int i = 0; i < nums.length; i++) {
        if (ints[nums[i]] != 0){
          result = nums[i];
          break;
        }else {
          ints[nums[i]] = 1;
        }
      }
      return result;
    }
  }
}
