package com.algorithm.algorithm;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class AlgorithmApplication {
  public static void main(String[] args) {
    System.out.println(romanToInt("MCMXCIV"));



  }

  public static int romanToInt(String s) {
    char[] charArray = s.toCharArray();
    int result = 0;
    ArrayList<Roman> romanArrayList = new ArrayList<>();
    for (int i = 0;i<charArray.length;i++){
      Roman roman = new Roman(charArray[i]);
      romanArrayList.add(roman);
    }
    int size = romanArrayList.size();
    for (int i = 0; i < size; i++) {
      Roman roman = romanArrayList.get(i);
      if (i == (size-1)){
        result+=roman.value;
        break;
      }
      if (roman.order >= romanArrayList.get(i+1).order) {
        result+= roman.value;
      }else {
        result-=roman.value;
      }
    }
    return result;
  }
  static class Roman {
    private char charName;

    private int order;
    private int value;
    Roman(char c){
      switch (c){
        case 'I' :
          this.charName = 'I';
          this.order = 1;
          this.value = 1;
          break;
        case 'V' :
          this.charName = 'V';
          this.order = 2;
          this.value = 5;
          break;
        case 'X' :
          this.charName = 'X';
          this.order = 3;
          this.value = 10;
          break;
        case 'L' :
          this.charName = 'L';
          this.order = 4;
          this.value = 50;
          break;
        case 'C' :
          this.charName = 'C';
          this.order = 5;
          this.value = 100;
          break;
        case 'D' :
          this.charName = 'D';
          this.order = 6;
          this.value = 500;
          break;
        case 'M' :
          this.charName = 'M';
          this.order = 7;
          this.value = 1000;
          break;
      }

    }

  }

}
