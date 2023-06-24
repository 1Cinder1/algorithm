package com.algorithm.algorithm.unzip;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/6/23 18:08
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/6/23 18:08
 * @updateRemark : 说明本次修改内容
 */

public interface PasswordCrackService {
  Integer THREAD_NUM=5;

  String run(String source,String dest);

  default public List<List<String>> getShardingList(List<String> numberStr){
    int num = numberStr.size() / THREAD_NUM;
    ArrayList<List<String>> dataList = new ArrayList<>();
    int index =0;
    int temp = 0;
    while (temp < numberStr.size()){
      temp = (index+1) * num;
      int fromIndex = index * num;
      int toIndex = temp > numberStr.size() ? numberStr.size() : temp;
      dataList.add(numberStr.subList(fromIndex,toIndex));
      index++;
    }
    return dataList;
  }

}
