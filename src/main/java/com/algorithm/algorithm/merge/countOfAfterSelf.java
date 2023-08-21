package com.algorithm.algorithm.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/7/5 17:35
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/7/5 17:35
 * @updateRemark : 说明本次修改内容
 */

public class countOfAfterSelf {
  public static void main(String[] args) {
  }
  public static List<Integer> countSmaller(int[] nums) {
    Integer[] result = new Integer[nums.length];
    Arrays.fill(result,0);
    mergeSort(nums,0,nums.length-1,result);
    System.out.println(Arrays.toString(result));
    return Arrays.asList(result);
  }

  private static void mergeSort(int[] nums,int start, int end, Integer[] result){
    if (start == end){
      result[start] = 0;
      return;
    }
    if (start +1 == end){
      if (nums[start] <= nums[end]){
        result[start] = 0;
      }else {
        result[start] = 1;
      }
      return;
    }
    int len = end - start;
    int mid = start + len / 2;
    int start1 = start,end1 = mid;
    int start2 = mid+1, end2 = end;
    System.out.println("mid is:  "+nums[mid]);
    mergeSort(nums,start1,end1,result);
    mergeSort(nums,start2,end2,result);

    for (int i = start1; i <= end1; i++) {
      for (int j = start2; j <= end2; j++) {
        if (nums[i] > nums[j]){
          result[i] += 1;
        }
      }
    }
  }
}
