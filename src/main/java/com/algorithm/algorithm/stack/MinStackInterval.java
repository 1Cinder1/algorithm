package com.algorithm.algorithm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/29 20:29
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/29 20:29
 * @updateRemark : 说明本次修改内容
 */

public class MinStackInterval {
  public static void main(String[] args) {

  }
  class MinStack {

    private ArrayList<Integer> numList;

    private ArrayList<Integer> minList;
    public MinStack() {
      this.numList = new ArrayList<>();
      this.minList = new ArrayList<>();
    }

    public void push(int val) {
      numList.add(val);
      int minSize = minList.size();
      if (minSize == 0 || val <= minList.get(minSize-1)){
        minList.add(val);
      }
    }
    public void pop() {
      int size = numList.size();
      if (size == 0){
        return;
      }
      int minSize = minList.size();
      if (minSize >0 && minList.get(minSize -1).equals(numList.get(size - 1))) {
        minList.remove(minSize -1);
      }
      numList.remove(size-1);
    }

    public int top() {
      int size = numList.size();
      return numList.get(size - 1);
    }

    public int getMin() {
      return minList.get(minList.size()-1);
    }
  }
}
