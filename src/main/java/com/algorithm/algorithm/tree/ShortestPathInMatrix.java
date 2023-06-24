package com.algorithm.algorithm.tree;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/5/26 22:31
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/5/26 22:31
 * @updateRemark : 说明本次修改内容
 */

public class ShortestPathInMatrix {

  private static ArrayList<Integer> result = new ArrayList();
  public static void main(String[] args) {
//    int[][] grid = {{0,1},{1,0}};
    int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
//    int[][] grid = {{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}};
    shortestPathBinaryMatrix(grid);
  }
  public static int shortestPathBinaryMatrix(int[][] grid) {
    int length = grid.length;
    if(grid[0][0] !=0 || grid[length-1][length-1] !=0 ){
      return -1;
    }
    if(length == 1){
      return 1;
    }
    grid[0][0] = -1;
    deepTree(grid,0,0,grid.length-1,1);
    int[] array = result.stream().mapToInt(Integer::valueOf).toArray();
    if (array.length == 0){
      return -1;
    }
    System.out.println(Arrays.stream(array).min().getAsInt());
    System.out.println(Arrays.toString(array));
    return 0;
  }

  public static void deepTree(int[][] grid,int row,int line,int n,int num){
    int[] traverse = {-1,1,0};
    for (int i =0;i<8;i++){
      int newRow = row + traverse[i / 3];
      int newLine = line + traverse[i % 3];
      System.out.println(newRow+"   "+newLine);
      if (newRow >=0 && newRow <=n && newLine >=0 && newLine <=n){
        if (grid[newRow][newLine] != 0){
          continue;
        }
        if (newRow ==n && newLine ==n){
          result.add(num+1);
        }else {
          int[][] copyOf = new int[n+1][n+1];
          for (int j = 0; j < grid.length; j++) {
            copyOf[i] = Arrays.copyOf(grid[i], n+1);
          }
          copyOf[newRow][newLine] = -1;
          deepTree(copyOf, newRow, newLine,n,num+1);
        }
      }
    }
  }
}
