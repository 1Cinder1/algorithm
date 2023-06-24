package com.algorithm.algorithm.account;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/6/23 20:26
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/6/23 20:26
 * @updateRemark : 说明本次修改内容
 */

public class AccountUnsafe implements Account{
  private Integer balance;

  public AccountUnsafe(Integer balance) {
    this.balance = balance;
  }


  @Override
  public  Integer getBalance() {
    return balance;
  }

  @Override
  public  void withdraw(Integer amount) {
    balance -= amount;
  }
}
