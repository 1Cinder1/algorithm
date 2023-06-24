package com.algorithm.algorithm.unzip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/6/23 18:24
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/6/23 18:24
 * @updateRemark : 说明本次修改内容
 */

public class StringUtil {
  /**
   * 数字
   */
  public static final String NUMBER = "0123456789";
  /**
   * 字母
   */
  public static final String ALPHABET = "abcdefghijklmnopqrstuvwyxz";
  /**
   * 符号
   */
  public static final String SYMBOL = "~!@#$%^&*()_+[]{};,.<>?-=";


  public static List<String> getStr(boolean includeNumber, boolean includeAlphabet,boolean includeSymbol,int length){
    ArrayList<String> result = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    if (includeNumber){
      sb.append(NUMBER);
    }
    if (includeAlphabet){
      sb.append(ALPHABET);
      //TODO 不清楚什么意思
      sb.append(ALPHABET.toUpperCase());
    }
    if (includeSymbol){
      sb.append(SYMBOL);
    }
    if (sb.length() <= length){
      result.add(sb.toString());
    }
    char[] chars = sb.toString().toCharArray();
    String[] strings = new String[chars.length];
    for (int i = 0; i < chars.length; i++) {
      strings[i] = String.valueOf(chars[i]);
    }
    String[] allLists = getAllLists(strings, length);
    return Arrays.asList(allLists);
  }

  private static String[] getAllLists(String[] elements, int length) {
    String[] allLists = new String[(int) Math.pow(elements.length, length)];
    if (length ==1){
      return elements;
    }else {
      String[] allSublists = getAllLists(elements, length - 1);
      int arrayIndex = 0;
      for (int i = 0; i < elements.length; i++) {
        for (int j = 0; j < allSublists.length; j++) {
          allLists[arrayIndex] = elements[i] + allSublists[j];
          arrayIndex++;
        }
      }

      return allLists;
    }
  }

  /**
   * 获取全部字符集合，包含数字，字母，特殊字符
   *
   * @param length
   * @return
   */
  public static List<String> getFullStr(int length) {
    return getStr(true, true, true, length);
  }

  /**
   * 获取数字字符集合
   *
   * @param length
   * @return
   */
  public static List<String> getNumberStr(int length) {
    return getStr(true, false, false, length);
  }

  /**
   * 获取字母字符集合
   *
   * @param length
   * @return
   */
  public static List<String> getAlphabetStr(int length) {
    return getStr(false, true, false, length);
  }

  /**
   * 获取特殊符号字符集合
   *
   * @param length
   * @return
   */
  public static List<String> getSymbolStr(int length) {
    return getStr(false, false, true, length);
  }

}
