package com.algorithm.algorithm.queue;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/7/23 22:08
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/7/23 22:08
 * @updateRemark : 说明本次修改内容
 */

public class TrappingRainWater {
  public static void main(String[] args) {
    int[] ints = {4, 2, 0, 3, 2, 5};
  }


  public static int calculateWater(int[] height){
    int length = height.length;
    int validHeight = Math.min(height[length-1] , height[0]);
    return (validHeight * length) - Arrays.stream(height).sum() + Math.abs(height[length-1] -height[0]);
  }


}
