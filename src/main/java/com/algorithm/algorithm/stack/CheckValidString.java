package com.algorithm.algorithm.stack;

import java.util.ArrayDeque;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/31 22:19
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/31 22:19
 * @updateRemark : 说明本次修改内容
 */

public class CheckValidString {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
    System.out.println(solution.checkValidString(s));
  }
  static class Solution {
    public boolean checkValidString(String s) {
      char[] charArray = s.toCharArray();
      ArrayDeque<String> characters = new ArrayDeque<>();
      for (int i = 0; i < charArray.length; i++) {
        char c = charArray[i];
        if (c == ')') {
          String first = characters.pollFirst();
          if (first == null) {
            return false;
          }
          continue;
        }
        if (c == '*') {
          characters.add(new StringBuilder().append(c).append(i).toString());
          continue;
        }
        characters.push(new StringBuilder().append(c).append(i).toString());
      }
      while (characters.size() >1) {
        String pop = characters.pollFirst();
        String last = characters.pollLast();
        if (pop.charAt(0) == '*') {
          return true;
        }else {
          if (Integer.valueOf(pop.substring(1)) >= Integer.valueOf(last.substring(1))) {
            return false;
          }
        }
      }
      return characters.size() ==0?true:(characters.pollFirst().charAt(0) == '*');
    }
  }

}
