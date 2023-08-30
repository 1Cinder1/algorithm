package com.algorithm.algorithm.binarySearch;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/27 22:03
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/27 22:03
 * @updateRemark : 说明本次修改内容
 */

public class SearchMatrix {
  public static void main(String[] args) {
    Solution solution = new Solution();
//    int[][] matrix = {
//      {1,3,5,7},
//      {10,11,16,20},
//      {23,30,34,60}
//    };
    int[][] matrix = {
      {1},
      {3}
    };
    int target = 3;
    System.out.println(solution.searchMatrix(matrix, target));
  }
  static class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int length = matrix.length;
      int[] targetMatrix = binarySearch(matrix, 0, length - 1, target);
      return findNum(targetMatrix,0,targetMatrix.length-1,target);
    }
    public int[] binarySearch(int[][] matrix,int start,int end,int target) {
      if (start == end){
        return matrix[start];
      }
      int mid = (start + end) / 2;
      if (matrix[mid+1][0] == target){
        return matrix[mid+1];
      }
      if (matrix[mid+1][0] > target) {
        return binarySearch(matrix,start,mid,target);
      }else {
        return binarySearch(matrix,mid+1,end,target);
      }
    }
    public boolean findNum(int[] nums,int start,int end,int target){
      if (start == end){
        return nums[start] == target;
      }
      int mid = (start + end) / 2;
      if (nums[mid] >= target) {
        return findNum(nums,start,mid,target);
      }else {
        return findNum(nums,mid+1,end,target);
      }
    }
  }
}
