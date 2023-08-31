package com.algorithm.algorithm.stack;

import java.util.ArrayDeque;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/31 10:42
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/31 10:42
 * @updateRemark : 说明本次修改内容
 */

public class CalculateRevPolishNotation {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
    System.out.println(solution.evalRPN(tokens));
  }
  static class Solution {
    public int evalRPN(String[] tokens) {
      ArrayDeque<Integer> integers = new ArrayDeque<>();
      for (String token : tokens) {
        char[] charArray = token.toCharArray();
        if (charArray.length == 1 && !Character.isDigit(charArray[0])) {
          Integer poll2 = integers.poll();
          Integer poll1 = integers.poll();
          switch (charArray[0]) {
            case '+':
              integers.push(poll1+poll2);
              break;
            case '-':
              integers.push(poll1-poll2);
              break;
            case '*':
              integers.push(poll1*poll2);
              break;
            case '/':
              integers.push(poll1/poll2);
              break;
          }
          continue;
        }
        integers.push(Integer.valueOf(token));
      }
      return integers.poll();
    }
  }
}
