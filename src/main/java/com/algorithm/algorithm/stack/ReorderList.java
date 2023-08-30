package com.algorithm.algorithm.stack;

import java.util.ArrayDeque;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/29 15:11
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/29 15:11
 * @updateRemark : 说明本次修改内容
 */

public class ReorderList {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {1,2,3,4};
    ListNode preHead = new ListNode();
    ListNode head = new ListNode();
    preHead.next = head;
    for (int i = 0; i < nums.length; i++) {
      head.next = new ListNode();
      head = head.next;
      head.val = nums[i];
    }
    solution.reorderList(preHead.next.next);
  }
  static class Solution {
    public void reorderList(ListNode head) {
      ListNode slowPointer = head,fastPointer = head;
      while (fastPointer != null){
        slowPointer = slowPointer.next;
        try {
          fastPointer = fastPointer.next.next;
        }catch (Exception e){
          break;
        }
      }
      ListNode temp2 = head;
      while (temp2.next != slowPointer){
        temp2 = temp2.next;
      }
      temp2.next = null;
      ArrayDeque<ListNode> listNodes = new ArrayDeque<>();
      while (slowPointer != null){
        listNodes.push(slowPointer);
        slowPointer = slowPointer.next;
      }
      while (listNodes.size() != 0){
        ListNode temp = head.next;
        ListNode poll = listNodes.poll();
        head.next = poll;
        head.next.next = temp;
        head = head.next.next;
      }
    }
  }
  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
