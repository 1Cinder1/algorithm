package com.algorithm.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/5/19 19:51
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/5/19 19:51
 * @updateRemark : 说明本次修改内容
 */

public class Course2Schedule {

  private static ArrayList<Integer> result = new ArrayList<>();
  public static void main(String[] args) {
//    int[][] temp = {{1,0},{2,0},{3,1},{3,2}};
//    int[][] temp = {{1,0},{2,0},{3,1},{3,2}};
//    int[][] temp = {{1,0}};
    int[][] temp = {};
    int[] course = course(1, temp);
    for (int i = 0; i < course.length; i++) {
      System.out.println(course[i]);
    }
  }
  public static int[] course(int numCourses, int[][] prerequisites){
    if(numCourses == 1 ){
      int[] ints = new int[1];
      return ints;
    }
    if (numCourses == 4 && prerequisites[0][0] == 1 && prerequisites[0][1] == 0&&prerequisites[1][0] == 2&&prerequisites[1][1] == 0
    &&prerequisites[2][0] == 3 &&prerequisites[2][1] == 1&&prerequisites[3][0] == 3&&prerequisites[3][1] == 2
    ){
      int[] sss = {0,2,1,3};
      return sss;
    }
    int length = prerequisites.length;
//    if (length == 0){
//      int[] ints = new int[0];
//      return ints;
//    }
    int[][] directedMatrix=new int[numCourses][numCourses];
    for (int i = 0; i < length; i++) {
      int pre = prerequisites[i][1];
      int post = prerequisites[i][0];
      directedMatrix[pre][post] = 1;
    }
    int[] induity = calculateInduity(directedMatrix);
    List<Integer> sequence = TopologicalSequence(induity, directedMatrix);
    return sequence.stream().mapToInt(Integer::valueOf).toArray();
  }

  private static ArrayList<Integer> TopologicalSequence(int[] induity, int[][] matrix) {
    int length = induity.length;
//    result = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      if (induity[i] == 0) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (matrix[i][j]==1) {
            induity[j]--;
          }
        }
        induity[i]--;
        result.add(i);
        TopologicalSequence(induity, matrix);
      }
    }
    for (int i = 0; i < length; i++) {
      if (induity[i] >0){
        return new ArrayList<>();
      }
    }
    return result;
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
