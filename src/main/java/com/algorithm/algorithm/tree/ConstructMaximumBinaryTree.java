package com.algorithm.algorithm.tree;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/31 17:57
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/31 17:57
 * @updateRemark : 说明本次修改内容
 */

public class ConstructMaximumBinaryTree {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {3,2,1,6,0,5};
    TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
    System.out.println(treeNode);
  }
  static class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      SegNode root = build(nums, 0, nums.length - 1);
      return build(root,0,nums.length-1,nums);
    }

    private SegNode build(int[] nums, int start, int end) {
      SegNode segNode = new SegNode(start,end);
      if (start == end) {
        segNode.max = nums[start];
        segNode.index = start;
        return segNode;
      }
      int mid = (start + end) / 2;
      segNode.left = build(nums,start,mid);
      segNode.right = build(nums,mid+1,end);
      if (segNode.left.max > segNode.right.max) {
        segNode.max = segNode.left.max;
        segNode.index = segNode.left.index;
      }else {
        segNode.max = segNode.right.max;
        segNode.index = segNode.right.index;
      }
      return segNode;
    }
    private TreeNode build(SegNode root,int start,int end,int[] nums) {
      if (start > end) {
        return null;
      }
      TreeNode treeNode = new TreeNode();
      int mid = (root.low + root.height) / 2;
      if (start <= root.low && end >= root.height) {
        treeNode.val = root.max;
        int index = root.index;
        return getTreeNode(root, start, end, nums, treeNode, mid, index);
      }
      if (start > root.height || end < root.low) {
        return null;
      }
      int index = findMax(root,start,end,nums);
      treeNode.val = nums[index];
      return getTreeNode(root, start, end, nums, treeNode, mid, index);
    }

    private TreeNode getTreeNode(SegNode root, int start, int end, int[] nums, TreeNode treeNode, int mid, int index) {
      if (index > mid) {
        treeNode.left = build(root, start, index-1,nums);
        treeNode.right = build(root.right,index+1,end,nums);
      }else {
        treeNode.left = build(root.left,start,index-1,nums);
        treeNode.right = build(root,index+1,end,nums);
      }
      return treeNode;
    }

    public int findMax(SegNode root,int start,int end,int[] nums){
      if (start<=root.low && end >= root.height) {
        return root.index;
      }
      int mid = (root.height + root.low) / 2;
      if (start > mid) {
        return findMax(root.right, start, end,nums);
      }
      if (end <= mid) {
        return findMax(root.left, start, end,nums);
      }
      int left = findMax(root.left, start, mid,nums);
      int right = findMax(root.right, mid + 1, end,nums);
      return nums[left] > nums[right]?left:right;
    }
  }
  static class SegNode {
    int height,low,max,index;

    SegNode left,right;

    SegNode(int low,int height) {
      this.height = height;
      this.low = low;
      this.max = Integer.MIN_VALUE;
      this.index = -1;
      this.left = null;
      this.right = null;
    }
  }
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
