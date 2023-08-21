package com.algorithm.algorithm;

import cn.hutool.Hutool;
import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.Collection;
import java.util.Random;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/7/4 15:23
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/7/4 15:23
 * @updateRemark : 说明本次修改内容
 */

public class RandomPonit {

  public static void main(String[] args) {
    int max = 10;
    for (int i = 0; i < max; i++) {
      System.out.println(internalNextInt(0,max));
    }
  }
  static final int internalNextInt(int min , int max) {
    return min + (int)(Math.random() * (max-min+1));
  }
  class Solution {

    private int[][][] areas;
    private int areasSum;

    public Solution(int[][] rects) {
      areas = new int[rects.length][2][4];
      for (int i = 0; i < rects.length; i++) {
        int x = rects[i][2] - rects[i][0];
        int y = rects[i][3] - rects[i][0];
        int i1 = x * y;
        areas[i][0][0] = i1;
        areas[i][1] = rects[i];
        areasSum += i1;
      }
      int[][][] ints = new int[rects.length][2][4];
      mergeSort(areas,0,areas.length-1,ints);
      areas = ints;
    }

    public void mergeSort(int[][][] arr,int start,int end,int[][][] result) {
      if (start == end){
        if (arr.length == 1){
          result[0] = arr[0];
        }
        return;
      }
      int length = end - start;
      int mid = (length /2) + start;
      int start1 = start,end1 = mid;
      int start2 = mid+1,end2 = end;
      mergeSort(arr,start1,end1,result);
      mergeSort(arr,start2,end2,result);
      int i = start;
      while (start1 <= end1 && start2 <=end2){
        result[i++] = arr[start1][0][0] < arr[start2][0][0] ? arr[start1++] : arr[start2++];
      }
      while (start1 <= end1){
        result[i++] = arr[start1++];
      }
      while (start2 <=end2){
        result[i++]= arr[start2++];
      }
      for (int j = start;j<=end;j++){
        arr[j] = result[j];
      }
    }

    private int[] randomRectangle(){
      int target = internalNextInt(0, areasSum);
      int sun = 0;
      for (int i = 0; i < areas.length; i++) {
        if (target >= sun && target <= sun + areas[i][0][0] ){
          return areas[i][1];
        }
        sun += areas[i][0][0];
      }
      return null;
    }

    public int[] pick() {
      int[] rect = randomRectangle();
      int x = internalNextInt(rect[0], rect[2]+1);
      int y = internalNextInt(rect[1], rect[3]+1);
      int[] a = {x,y};
      return a;
    }
  }
}
