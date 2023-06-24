package com.algorithm.algorithm;

import java.util.Arrays;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/5/25 10:35
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/5/25 10:35
 * @updateRemark : 说明本次修改内容
 */

public class Examination {
  public static void main(String[] args) {
    int count =0;
    int n = (int) Math.pow(2,7);
    System.out.println(n);
    for (int i = 1;i<=n;i++){
      int j = n/2;
      while (j>= 1){
        count++;
        if (j%2 ==1 ){
          j=0;
        }else {
          j=j/2;
        }
      }
    }
    String s = "aaaaa";
    System.out.println(count);
  }
}
