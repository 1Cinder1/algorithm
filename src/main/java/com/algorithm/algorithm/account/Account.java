package com.algorithm.algorithm.account;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangxiaobo
 * @version : v1.0
 * @description : 一句话描述该类的功能
 * @createTime : 2023/6/23 20:25
 * @updateUser : zhangxiaobo
 * @updateTime : 2023/6/23 20:25
 * @updateRemark : 说明本次修改内容
 */

public interface Account {
  // 获取余额
  Integer getBalance();
  // 取款
  void withdraw(Integer amount);

  /**
   * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
   * 如果初始余额为 10000 那么正确的结果应当是 0
   */
  static void demo(Account account) {
    List<Thread> ts = new ArrayList<>();
    long start = System.nanoTime();
    for (int i = 0; i < 1000; i++) {
      ts.add(new Thread(() -> {
        account.withdraw(10);
      }));
    }
    ts.forEach(Thread::start);
    ts.forEach(t -> {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    long end = System.nanoTime();
    System.out.println(account.getBalance()
      + " cost: " + (end-start)/1000_000 + " ms");
  }
}
