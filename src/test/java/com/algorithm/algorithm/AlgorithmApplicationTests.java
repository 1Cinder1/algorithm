package com.algorithm.algorithm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlgorithmApplicationTests {

  @Test
  void contextLoads() {
    String s = "           1232  dawda4193qweqzdwit   hword43s  4553";
    String[] split = s.split(" ");
    for (String s1 : split) {
      System.out.println(s1);
    }
  }

}
