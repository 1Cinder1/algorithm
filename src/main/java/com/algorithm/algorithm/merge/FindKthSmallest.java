package com.algorithm.algorithm.merge;

import java.util.Arrays;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/30 10:04
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/30 10:04
 * @updateRemark : 说明本次修改内容
 */

public class FindKthSmallest {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] matrix = {
      {1,5,9},
      {10,11,13},
      {12,13,15}
    };
    int k = 8;
    System.out.println(solution.kthSmallest(matrix, k));
  }
  static class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      int rowLength = matrix.length;
      int lineLength = matrix[0].length;
      int[] ints = Arrays.copyOf(matrix[0], rowLength * lineLength);
      int pointer = lineLength;
      for (int i = 1; i < matrix.length; i++) {
        if (ints[pointer-1]<matrix[i][0] && pointer>= k){
          break;
        }
        ints = merge(ints, matrix[i],pointer-1);
        pointer = (i+1)*lineLength;
      }
      return ints[k-1];
    }

    public int[] merge(int[] ints,int[] matrix,int pointer) {
      int start1 = 0,start2=0;
      int end1 = pointer,end2 = matrix.length-1;
      int i = 0;
      int[] result = new int[ints.length];
      while (start1 <= end1 && start2 <= end2) {
        result[i++] = ints[start1]<matrix[start2]?ints[start1++]:matrix[start2++];
      }
      while (start1<=end1) {
        result[i++] = ints[start1++];
      }
      while (start2<=end2){
        result[i++] = matrix[start2++];
      }
      return result;
    }
  }
}
