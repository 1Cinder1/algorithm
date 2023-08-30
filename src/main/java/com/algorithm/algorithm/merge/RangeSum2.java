package com.algorithm.algorithm.merge;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/26 11:39
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/26 11:39
 * @updateRemark : 说明本次修改内容
 */

public class RangeSum2 {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {-2,5,-1};
    int lower = -2;
    int upper = 2;
    System.out.println(solution.countRangeSum(nums, lower, upper));
  }
  static class Solution {
    /**
     * @author Zhangxiaobo
     * @description  [i,j] is one of range between lower and upper
     * show that preSum[j]-preSum[i-1] is one of num between lower and upper,
     * so that preSum[j] is one of num between lower+preSum[i-1],upper+preSum[i-1],
     * mean that for every j, how many nums of preSum[0...j-1] between preSum[j]-upper and preSum[j]-lower
     * @createTime  2023/8/26 18:09
     * @return int
     **/
    public int countRangeSum(int[] nums, int lower, int upper) {
      int length = nums.length;
      long[] preSum = new long[length + 1];
      for (int i = 0; i < nums.length; i++) {
        preSum[i+1]=preSum[i]+nums[i];
      }
      TreeSet<Long> treeSet = new TreeSet<>();
      for (int i = 0; i < preSum.length; i++) {
        treeSet.add(preSum[i]);
        treeSet.add(preSum[i]-upper);
        treeSet.add(preSum[i]-lower);
      }
      HashMap<Long, Integer> values = new HashMap<>();
      int index = 0;
      for (Long aLong : treeSet) {
        values.put(aLong,index++);
      }
      SegNode root = build(0, values.size() - 1);
      int result = 0;
      for (int i = 0; i < preSum.length; i++) {
        Integer left = values.get(preSum[i] - upper);
        Integer right = values.get(preSum[i] - lower);
        result+=count(root,left,right);
        //insert function must be in the loop, in order to
        //ensure that it will only count 0...i-1 everytime
        insert(root,values.get(preSum[i]));
      }
      return result;
    }
    public void insert(SegNode root,Integer num){
      root.add++;
      if (root.height == root.low){
        return;
      }
      int mid = (root.height + root.low)/2;
      if (num <= mid){
        insert(root.left,num);
      }else {
        insert(root.right,num);
      }
    }
    public SegNode build(int lower,int upper){
      SegNode node = new SegNode(lower, upper);
      if (lower == upper){
        return node;
      }
      int mid = (lower + upper) / 2;
      node.left = build(lower,mid);
      node.right = build(mid+1,upper);
      return node;
    }
    public int count(SegNode root,Integer left,Integer right){
      if (left > root.height || right < root.low){
        return 0;
      }
      if (left <= root.low && right >= root.height){
        return root.add;
      }
      return count(root.left,left,right)+count(root.right,left,right);
    }
    class SegNode {
      int height,low,add;
      SegNode left,right;

      public SegNode(int low,int height){
        this.height = height;
        this.low = low;
        this.add = 0;
        this.left = null;
        this.right = null;
      }
    }





  }
}
