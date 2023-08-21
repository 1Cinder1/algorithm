package com.algorithm.algorithm.dynamic;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/16 15:08
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/16 15:08
 * @updateRemark : 说明本次修改内容
 */

public class PalindromicSubStr {
  public static void main(String[] args) {
    String s = "ccd";
    PalindromicSubStr palindromicSubStr = new PalindromicSubStr();
    System.out.println(palindromicSubStr.longestPalindrome(s));
  }
  public String longestPalindrome(String s) {
    int length = s.length();
    if (length ==1) {
      return s;
    }
    boolean[][] matrix = new boolean[length][length];
    for (int i = 0; i < length; i++) {
      matrix[i][i] = true;
    }
    int maxLength = 1;
    int start = 0;
    for (int L = 2;L<=length;L++){
      for (int i = 0; i < length-1; i++) {
        int end = i + L - 1;
        if (end >= length) {
          break;
        }
        if (s.charAt(i)!=s.charAt(end)){
          matrix[i][end] = false;
        }else {
          if (L ==2){
            matrix[i][end] = true;
          }else {
            matrix[i][end] = matrix[i+1][end-1];
          }
        }
        if (matrix[i][end] && L > maxLength){
          maxLength = L;
          start = i;
        }
      }
    }
    return s.substring(start,start+maxLength);
  }


}
