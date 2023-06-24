package com.algorithm.algorithm.merge;

import java.util.ArrayList;
import java.util.Arrays;

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

   public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public static void main(String[] args) {
    ListNode headNode = new ListNode(1);
//    headNode.next = new ListNode(2);
//    headNode.next.next = new ListNode(1);
//    headNode.next.next.next = new ListNode(3);
    int[] toArray = listToArray(headNode);
    System.out.println(Arrays.toString(toArray));
    int end = toArray.length;
    int[] result = new int[end];
    mergeSort(toArray,0,end-1,result);
//    arrayToList(result);
    System.out.println(Arrays.toString(result));
  }
  public static int[] listToArray(ListNode head) {
    ArrayList<Integer> result = new ArrayList<>();
    while (head !=null){
      result.add(head.val);
      head = head.next;
    }
    int[] result2 = result.stream().mapToInt(Integer::valueOf).toArray();
    return result2;
  }
  public static ListNode arrayToList(int[] array) {
    ListNode headNode = new ListNode();
    ListNode nextNode = new ListNode(array[0]);
    headNode.next = nextNode;
    for (int i = 1; i < array.length; i++) {
      nextNode.next = new ListNode(array[i]);
      nextNode = nextNode.next;
    }
    return headNode;
  }


  public static void mergeSort(int[] arr,int start,int end,int[] result) {
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
      result[i++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
    }
    while (start1 <= end1){
      result[i++] = arr[start1++];
    }
    while (start2 <=end2){
      result[i++] = arr[start2++];
    }
    for (int j = start;j<=end;j++){
      arr[j] = result[j];
    }
  }
}
