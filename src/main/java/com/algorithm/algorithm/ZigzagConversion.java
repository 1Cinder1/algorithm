package com.algorithm.algorithm;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/5/18 12:04
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/5/18 12:04
 * @updateRemark : 说明本次修改内容
 */

public class ZigzagConversion {

  static class Zigzag {
    private char[] nameList;
    private int[] rowList;
    private int[] columnList;
    private int numRows;

    Zigzag(String s,int numRows){
      this.numRows = numRows;
      this.nameList = s.toCharArray();
      int length = this.nameList.length;
      this.rowList = new int[length];
      this.columnList = new int[length];
      int rowNum =0;
      int maxRowNum = numRows-1;
      int lineNum = 0;
      for (int i = 0; i < length; i++) {
        if (rowNum <= maxRowNum){
          //说明这一列还没排完
          this.rowList[i] = rowNum;
          this.columnList[i] = lineNum;
          rowNum++;
        }else {
          lineNum++;
          this.columnList[i] = lineNum;
          this.rowList[i] = rowNum -1;
          if (this.rowList[i] == 1){
            rowNum=0;
          }
        }
      }
    }
  }

  private static String convert(String s,int numRows){
    int groupNum = (numRows*2)-2;
    if (groupNum == 0){
      groupNum =1;
    }
    char[] charArray = s.toCharArray();
    char[] characterArrayList = new char[charArray.length];
    int mark = 0;
    for (int i = 0; i < numRows; i++) {
      if (i == 0|| i == numRows-1){
        int temp= i;
        while (true){
          if (temp >= charArray.length){
            break;
          }
          characterArrayList[mark] = charArray[temp];
          mark++;
          temp+=groupNum;
        }
      }else {
        int temp= i;
        int temp2;
        while (true){
          if (temp >= charArray.length){
            break;
          }
          characterArrayList[mark] = charArray[temp];
          mark++;
          temp2 = temp + groupNum - 2*i;
          if (temp2 >= charArray.length){
            break;
          }
          characterArrayList[mark] = charArray[temp2];
          mark++;
          temp+=groupNum;
        }
      }
    }
    return String.valueOf(characterArrayList);
  }
  public static void main(String[] args) {
    System.out.println(convert("A",1));
  }
}
