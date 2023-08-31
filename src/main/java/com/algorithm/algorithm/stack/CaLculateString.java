package com.algorithm.algorithm.stack;

import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/29 21:03
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/29 21:03
 * @updateRemark : 说明本次修改内容
 */

public class CaLculateString {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "-1";
//    String s = "1*2-3/4+5*6-7*8+9/10";
    System.out.println(solution.calculate(s));
  }
  static class Solution {
    public int calculate(String s) {
      s = s.replaceAll(" ", "");
      ArrayDeque<Integer> numStack = new ArrayDeque<>();
      ArrayDeque<String> strStack = new ArrayDeque<>();
      char[] charArray = s.toCharArray();
      boolean startCalculate = false;
      boolean isPreNum = false;
      for (int i = 0; i < charArray.length; i++) {
        if (startCalculate) {
          if (isPreNum) {
            Integer poll = numStack.poll();
            numStack.push(Integer.valueOf(String.valueOf(poll)+charArray[i]));
          }else {
            numStack.push(Character.getNumericValue(charArray[i]));
          }
          if (i+1 < charArray.length && Character.isDigit(charArray[i+1])){
            isPreNum = true;
            continue;
          }
          Integer numPoll2 = numStack.poll();
          Integer numPoll1 = numStack.poll();
          String strPoll = strStack.poll();
          if (strPoll.equals("*")) {
            numStack.push(numPoll1 * numPoll2);
          }else {
            numStack.push(numPoll1 / numPoll2);
          }
          startCalculate = false;
          continue;
        }
        if (Character.isDigit(charArray[i])) {
          if (isPreNum) {
            Integer poll = numStack.poll();
            numStack.push(Integer.valueOf(String.valueOf(poll)+charArray[i]));
            continue;
          }
          isPreNum = true;
          numStack.push(Character.getNumericValue(charArray[i]));
        }else {
          isPreNum = false;
          if (String.valueOf(charArray[i]).equals("*") || String.valueOf(charArray[i]).equals("/")) {
            startCalculate = true;
          }
          strStack.push(String.valueOf(charArray[i]));
        }
      }
      while (strStack.size() != 0){
        Integer numPoll1 = numStack.pollLast();
        Integer numPoll2 = numStack.pollLast();
        String strPoll = strStack.pollLast();
        if (strPoll.equals("+")) {
          numStack.add(numPoll1 + numPoll2);
        }else {
          numStack.add(numPoll1 - numPoll2);
        }
      }
      return numStack.poll();
    }
  }
}
