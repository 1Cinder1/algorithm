package com.algorithm.algorithm.merge;

import cn.hutool.core.bean.BeanUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/5/21 21:05
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/5/21 21:05
 * @updateRemark : 说明本次修改内容
 */

public class MergeKSortedLists {
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode mergeKLists(ListNode[] lists) {
    List<ListNode> list = Arrays.asList(lists);
    return mergeKLists(list);
  }
  public ListNode mergeKLists(List<ListNode> lists){
    int length = lists.size();
    if (length == 1){
      return lists.get(0);
    }
    ArrayList<ListNode> listNodes = new ArrayList<>();
    if (length %2 ==1){
      listNodes.add(lists.get(length-1));
    }
    for (int i = 0; i < length; i+=2) {
      if (i+1 >= length){
        break;
      }
      ListNode resultHead = new ListNode();
      ListNode nextNode = new ListNode();
      resultHead.next = nextNode;
      ListNode listOne = lists.get(i);
      ListNode list2 = lists.get(i+1);
      while (listOne != null && list2 != null){
        nextNode.val = listOne.val < list2.val ? listOne.val :list2.val;
        listOne = listOne.next;
        list2 = list2.next;
        ListNode temp = new ListNode();
        nextNode.next = temp;
        nextNode = temp;
      }
      while (listOne != null){
        nextNode = listOne;
      }
      while (list2 != null){
        nextNode = listOne;
      }
      listNodes.add(resultHead.next);
    }
    return mergeKLists(listNodes);
  }


  public void mergeSort(ListNode[] arrList,ListNode[] resultList,int start,int end){
    if (start == end){
      return;
    }
    int length = end - start;
    int mid = length >> 2 + start;
    int startOne = start,endOne = mid;
    int start2 = mid+1,end2=end;
    mergeSort(arrList,resultList,startOne,endOne);
    mergeSort(arrList,resultList,start2,end2);
    int k = start;
    while (startOne<=endOne && start2<=end2){
      resultList[k++] = arrList[startOne].val < arrList[start2].val ? arrList[startOne++] : arrList[start2++];
    }
    while (startOne<=endOne){
      resultList[k++] = arrList[startOne++];
    }
    while (start2<=end2){
      resultList[k++]=arrList[start2++];
    }
    for (int i = start; i <= end; i++) {
      arrList[i] = resultList[i];
    }
  }
}
