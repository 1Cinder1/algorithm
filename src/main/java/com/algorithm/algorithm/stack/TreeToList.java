package com.algorithm.algorithm.stack;

import java.util.ArrayDeque;
/**
  @author : zhangxiaobo
  @version : v1.0
  @description : 一句话描述该类的功能
  @createTime : 2023/8/29 14:37
  @updateUser : zhangxiaobo
  @updateTime : 2023/8/29 14:37
  @updateRemark : 说明本次修改内容
 */

public class TreeToList {
  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
    solution.flatten(root);
  }
  static class Solution {
    public void flatten(TreeNode root) {
      ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
      if (root == null){
        return;
      }
      traverseTree(root,treeNodes);
      TreeNode resultRoot = new TreeNode();
      TreeNode temp = new TreeNode();
      resultRoot.right = temp;
      while (treeNodes.size() != 0){
        temp.right = new TreeNode();
        temp = temp.right;
        TreeNode poll = treeNodes.poll();
        temp.val = poll.val;
      }
      root.left = null;
      root.val = resultRoot.right.right.val;
      root.right = resultRoot.right.right.right;
    }
    public void traverseTree(TreeNode root, ArrayDeque<TreeNode> treeNodes){
      treeNodes.add(root);
      TreeNode left = root.left;
      TreeNode right = root.right;
      if (left != null){
        traverseTree(left,treeNodes);
      }
      if (right != null){
        traverseTree(right,treeNodes);
      }
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
