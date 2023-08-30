package com.algorithm.algorithm.merge;

import java.util.*;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/19 17:10
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/19 17:10
 * @updateRemark : 说明本次修改内容
 */

public class RangeSum {
  public static void main(String[] args) {
    RangeSum rangeSum = new RangeSum();
    int[] ints = {-2,5,-1};
    int lower = -2;
    int upper = 2;
    Solution solution = new Solution();
  }
  public int countRangeSum(int[] nums, int lower, int upper) {
    int length = nums.length;
    if (length == 1){
      return 1;
    }
    long[] range = new long[length+1];
    for (int i = 0; i < nums.length; i++) {
      range[i+1] = range[i] + nums[i];
    }
    long[] sorted = new long[length+1];
    return mergeSort(range,0,length,0,lower,upper,sorted);
  }


  public int mergeSort(long[] range,int start,int end,int result,int lower,int upper,long[] sorted){
    if (start==end) {
      return 0;
    }
    int length = end - start;
    int mid = start+length/2;
    int start1=start, end1=mid,start2 = mid+1 >end? end:mid+1,end2=end;
    int e1 = mergeSort(range, start1, end1,result,lower,upper,sorted);
    int e2 = mergeSort(range, start2, end2,result,lower,upper,sorted);
    result+=e1+e2;
    int l = mid+1,r=mid+1;
    int i=start;
    while (i<=mid) {
      while (l <= end && range[l]-range[i]< lower ){
        l++;
      }
      while (r <= end && range[r]-range[i] <= upper){
        r++;
      }
      result+=(r-l);
      i++;
    }
    i=start;
    while (start1<=end1 && start2<=end2){
      sorted[i++] = range[start1] < range[start2] ? range[start1++]:range[start2++];
    }
    while (start1<=end1) {
      sorted[i++] = range[start1++];
    }
    while (start2<=end2) {
      sorted[i++] = range[start2++];
    }
    for (int j = start;j<=end;j++){
      range[j] = sorted[j];
    }
    return result;
  }
//  static class Solution {
//    public int countRangeSum(int[] nums, int lower, int upper) {
//      long s = 0;
//      long[] sum = new long[nums.length + 1];
//      for (int i = 0; i < nums.length; ++i) {
//        s += nums[i];
//        sum[i + 1] = s;
//      }
//      return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
//    }
//
//    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
//      if (left == right) {
//        return 0;
//      } else {
//        int mid = (left + right) / 2;
//        int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
//        int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
//        int ret = n1 + n2;
//
//        // 首先统计下标对的数量
//        int i = left;
//        int l = mid + 1;
//        int r = mid + 1;
//        while (i <= mid) {
//          while (l <= right && sum[l] - sum[i] < lower) {
//            l++;
//          }
//          while (r <= right && sum[r] - sum[i] <= upper) {
//            r++;
//          }
//          ret += r - l;
//          i++;
//        }
//
//        // 随后合并两个排序数组
//        long[] sorted = new long[right - left + 1];
//        int p1 = left, p2 = mid + 1;
//        int p = 0;
//        while (p1 <= mid || p2 <= right) {
//          if (p1 > mid) {
//            sorted[p++] = sum[p2++];
//          } else if (p2 > right) {
//            sorted[p++] = sum[p1++];
//          } else {
//            if (sum[p1] < sum[p2]) {
//              sorted[p++] = sum[p1++];
//            } else {
//              sorted[p++] = sum[p2++];
//            }
//          }
//        }
//        for (int j = 0; j < sorted.length; j++) {
//          sum[left + j] = sorted[j];
//        }
//        return ret;
//      }
//    }
//  }

  static class Solution {


  }



}
