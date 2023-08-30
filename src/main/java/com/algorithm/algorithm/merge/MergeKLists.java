package com.algorithm.algorithm.merge;

import java.util.ArrayList;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/27 17:57
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/27 17:57
 * @updateRemark : 说明本次修改内容
 */

public class MergeKLists {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] nums = {
      {1,4,5},{1,3,4},{2,6}
    };
    Solution.ListNode[] listNodes = new Solution.ListNode[nums.length];
    for (int i = 0; i < nums.length; i++) {
      Solution.ListNode head = new Solution.ListNode();
      listNodes[i] = head;
      for (int mid : nums[i]) {
        head.val = mid;
        head.next = new Solution.ListNode();
        head = head.next;
      }
    }
    Solution.ListNode listNode = solution.mergeKLists(listNodes);
    System.out.println(listNode);
  }

  static class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      ArrayList<ListNode> listNodes = new ArrayList<>();

      for (int i = 0; i < lists.length; i+=2) {
        if (i+1 >=lists.length){
          break;
        }
        listNodes.add(merge(lists[i],lists[i+1],1));
      }
      int capacity = 2;
      int index = 0;
      while (listNodes.size() > 1){
        int size = listNodes.size();
        while (index < size/2){
          merge(listNodes.get(index),listNodes.get(index+1),capacity);
          listNodes.remove(index+1);
          index++;
        }
        capacity *=2;
      }
      return listNodes.get(0);
    }
    public ListNode merge(ListNode listNode1,ListNode listNode2,int capacity){
      ListNode temp = new ListNode();
      ListNode head = temp;
      ListNode head2 = listNode1;
      int left=capacity,right=capacity;
      while (left >0 && right >0 && listNode1 != null && listNode2 != null){
        ListNode temp2 = new ListNode();
        temp.next = temp2;
        temp = temp2;
        if (listNode1.val > listNode2.val) {
          temp.val = listNode2.val;
          listNode2 = listNode2.next;
          right--;
        }else {
          temp.val = listNode1.val;
          listNode1 = listNode1.next;
          left--;
        }
      }
      while (left >0 && listNode1 != null) {
        ListNode temp2 = new ListNode();
        temp.next = temp2;
        temp = temp2;
        temp.val = listNode1.val;
        listNode1 = listNode1.next;
        left--;
      }
      while (right >0 && listNode2 != null) {
        ListNode temp2 = new ListNode();
        temp.next = temp2;
        temp = temp2;
        temp.val = listNode2.val;
        listNode2 = listNode2.next;
        right--;
      }
      temp.next = listNode2;
      head2.val = head.next.val;
      head2.next = head.next.next;
      return head2;

    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  }
}
