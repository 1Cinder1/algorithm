package com.algorithm.algorithm.stack;

import java.util.*;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/29 21:54
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/29 21:54
 * @updateRemark : 说明本次修改内容
 */

public class RmDuplicateStr {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "bcabc";
    System.out.println(solution.removeDuplicateLetters(s));
  }
  static class Solution {
    public String removeDuplicateLetters(String s) {
      char[] charArray = s.toCharArray();
      ArrayDeque<Character> characters = new ArrayDeque<>();
      int[] visit = new int[26];
      int[] ints = new int[26];
      for (int i = 0; i < charArray.length; i++) {
        ints[charArray[i] - 'a'] = i;
      }
      characters.push(charArray[0]);
      visit[charArray[0] - 'a'] =  1;
      for (int i = 1; i < charArray.length; i++) {
        Character first = characters.getFirst();
        char c = charArray[i];
        if (visit[c - 'a'] == 1) {
          continue;
        }
        visit[c - 'a'] = 1;
        while (first > c && ints[first - 'a'] > i) {
          characters.poll();
          visit[first - 'a'] = 0;
          try {
            first = characters.getFirst();
          }catch (Exception e){
            break;
          }
        }
        characters.push(c);
      }
      StringBuilder stringBuilder = new StringBuilder();
      while (characters.size() != 0) {
        stringBuilder.append(characters.pollLast());
      }
      return stringBuilder.toString();
    }
  }
}
