package com.algorithm.algorithm.dynamic;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/8/16 18:52
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/8/16 18:52
 * @updateRemark : 说明本次修改内容
 */

public class MyAtoi {
  public static void main(String[] args) {
    MyAtoi myAtoi = new MyAtoi();
    String s = " ";
    System.out.println(myAtoi.myAtoi(s));
  }
  public int myAtoi(String s) {
    String without = s.replaceAll(" ", "");
    String[] split = s.split("");
    if (without.isEmpty()){
      return 0;
    }
    int length = without.length();
    char c = without.charAt(0);
    boolean isNegative = false;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (i == 0 && c == '-'){
        isNegative = true;
        continue;
      }
      if (i == 0 && c == '+'){
        continue;
      }
      char item = without.charAt(i);
      if (!Character.isDigit(item)) {
        break;
      }
      stringBuilder.append(item);
    }
    return justifyIsValid(stringBuilder.toString(),isNegative);
  }

  public int justifyIsValid(String s,boolean isNegative){
    int val ;
    if (s.isEmpty()){
      return 0;
    }
    try {
      val = Integer.valueOf(s).intValue();
    }catch (Exception e){
      if (isNegative){
        val = (int) Math.pow(2,31);
      }else {
        val = (int) (Math.pow(2,31)-1);
      }
    }
    return isNegative?-val:val;
  }
}
