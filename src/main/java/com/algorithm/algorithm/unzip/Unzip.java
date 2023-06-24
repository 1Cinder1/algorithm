package com.algorithm.algorithm.unzip;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/6/23 18:05
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/6/23 18:05
 * @updateRemark : 说明本次修改内容
 */

public class Unzip {
  public static void main(String[] args) {
    PasswordCrackService service = new ThreadProcessPasswordCrackServiceImpl();
    String source = "E:\\spring.zip";
    String dest = "E:\\test";
    service.run(source, dest);
  }
}
