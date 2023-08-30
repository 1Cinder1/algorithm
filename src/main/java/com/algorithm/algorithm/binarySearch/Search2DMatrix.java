package com.algorithm.algorithm.binarySearch;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/30 16:38
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/30 16:38
 * @updateRemark : 说明本次修改内容
 */

public class Search2DMatrix {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] matrix = {
      {-1,3}
    };
    int target = 5;
    System.out.println(solution.searchMatrix(matrix, target));
  }
  static class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int rowLength = matrix.length;
      int lineLength = matrix[0].length;
      int indexLength = rowLength < lineLength?rowLength:lineLength;
      for (int i = 0; i < indexLength; i++) {
        int start1 = i, start2 = i;
        while (start1 < lineLength ){
          if (matrix[i][start1] ==target){
            return true;
          }
          start1++;
        }
        while (start2 < rowLength ){
          if (matrix[start2][i] ==target){
            return true;
          }
          start2++;
        }
      }

      return false;
    }
  }
}
