package com.algorithm.algorithm;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/5/18 20:26
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/5/18 20:26
 * @updateRemark : 说明本次修改内容
 */

public class CourseSchedule {
  public static void main(String[] args) {
    int[][] temp = {{1,0}};
    course(2,temp);
  }
  public static boolean course(int numCourses, int[][] prerequisites){
    int[][] directedMatrix=new int[numCourses][numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      int pre = prerequisites[i][1];
      int post = prerequisites[i][0];
      directedMatrix[pre][post] = 1;
    }
    int[] induity = calculateInduity(directedMatrix);
    return TopologicalSequence(induity,directedMatrix);
  }

  private static boolean TopologicalSequence(int[] induity,int[][] matrix) {
    for (int i = 0; i < induity.length; i++) {
      if (induity[i] == 0) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (matrix[i][j]==1) {
            induity[j]--;
          }
        }
        induity[i]--;
        TopologicalSequence(induity, matrix);
      }
    }
    for (int i = 0; i < induity.length; i++) {
      if (induity[i] >0){
        return false;
      }
    }
    return true;
  }


  private static int[] calculateInduity(int[][] matrix) {
    int[] result = new int[matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1){
          result[j]++;
        }
      }
    }
    return result;
  }

  public static void print2DimensionalArray(int[][] matrix){
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.printf("%d\t",matrix[i][j]);
      }
      System.out.println();
    }

  }
}
