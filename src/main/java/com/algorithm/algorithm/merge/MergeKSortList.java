package com.algorithm.algorithm.merge;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/7/5 16:27
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/7/5 16:27
 * @updateRemark : 说明本次修改内容
 */

public class MergeKSortList {
  public static void main(String[] args) {
    merge(new ListNode(1,new ListNode(4,new ListNode(5))),new ListNode(1,new ListNode(3,new ListNode(4))));
  }
  public ListNode mergeKLists(ListNode[] lists) {
    return sort(lists, 0, lists.length - 1);
  }

  private static ListNode merge(ListNode list1,ListNode list2){
    ListNode head = new ListNode();
    ListNode next = new ListNode();
    head.next = next;
    while (list1 != null && list2.next != null){
      if (list1.val < list2.val){
        next.val = list1.val;
        list1 = list1.next;
      }else {
        next.val = list2.val;
        list2 = list2.next;
      }
      next.next = new ListNode();
      next = next.next;
    }
    if (list1 != null){
      next.val = list1.val;
      next.next = list1.next;
    }
    if (list2 != null){
      next.val = list2.val;
      next.next = list2.next;
    }
    return head.next;
  }
  private ListNode sort(ListNode[] lists, int start, int end){
    if (start == end){
      return lists[start];
    }else if (start +1 == end){
      return merge(lists[start],lists[end]);
    }
    int len = end - start;
    int mid = start + len / 2;
    int start1 = start, end1 = mid;
    int start2 = mid+1, end2 = end;
    ListNode sort1 = sort(lists, start1, end1);
    ListNode sort2 = sort(lists, start2, end2);
    ListNode merge = merge(sort1, sort2);
    return merge;

  }

   static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
