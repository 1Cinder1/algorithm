package com.algorithm.algorithm.merge;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/5/25 22:48
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/5/25 22:48
 * @updateRemark : 说明本次修改内容
 */

public class SortList {


  public static void main(String[] args) {
    int[] nums = {4,19,14,5,-3,1,8,5,11,15};
//    int[] nums = {-1,5,3,4,0};
    ListNode head = new ListNode();
    ListNode temp = new ListNode();
    head.next = temp;
    for (int i = 0; i < nums.length; i++) {
      ListNode listNode = new ListNode();
      temp.next = listNode;
      temp = listNode;
      temp.val = nums[i];
    }
    Solution solution = new Solution();
    ListNode listNode = solution.sortList(head.next.next);
    while (listNode != null){
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }
  /**
   * @author Zhangxiaobo
   * @description use bottom-to-up merge-sort to sort the ListNode,step from 1 to 2 4 8....
   * @createTime  2023/8/26 23:14
   * @return
   **/
  static class Solution {
    public ListNode sortList(ListNode head) {
      int step = 1;

      int length = 0;
      ListNode node = head;
      while (node != null) {
        length++;
        node = node.next;
      }
      ListNode head2 = null;
      if (length == 1){
        head2 = head;
      }
      node = head;
      while (step < length) {
        while (head != null){
          ListNode temp = head;
          for (int i = 0; i < step; i+=1) {
            if (head != null){
              head = head.next;
            }
          }
          head2 = mergeSort(temp,head,step-1);
          for (int i = 0; i < step; i+=1) {
            if (head != null){
              head = head.next;
            }
          }
        }
        step = step*2;
        head = node;
      }
      return head2;
    }

    public ListNode mergeSort(ListNode head1,ListNode head2,int loop){
      if (head2 == null){
        return head1;
      }
      ListNode listNode = new ListNode();
      ListNode tt = new ListNode();
      listNode.next = tt;
      int left = loop,right = loop;
      ListNode head = head1;
      while (left >-1 && right >-1 && head1 != null && head2 != null){
        ListNode temp = new ListNode();
        tt.next = temp;
        tt = temp;
        if (head1.val < head2.val){
          tt.val = head1.val;
          head1 = head1.next;
          left--;
        }else {
          tt.val = head2.val;
          head2 = head2.next;
          right--;
        }
      }
      listNode = listNode.next;
      while (left>-1 && head1 != null){
        ListNode temp = new ListNode();
        tt.next = temp;
        tt = temp;
        tt.val = head1.val;
        if (head1.next != null){
          head1 = head1.next;
        }else {
          break;
        }
        left--;
      }
      while (right>-1 && head2 != null){
        ListNode temp = new ListNode();
        tt.next = temp;
        tt = temp;
        tt.val = head2.val;
        if (head2.next != null){
          head2 = head2.next;
        }else {
          head2 = null;
          break;
        }
        right--;
      }
      head.val = listNode.next.val;
      head.next = listNode.next.next;
      tt.next = head2;
      return head;
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
