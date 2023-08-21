//package com.algorithm.algorithm;
//
//import java.util.*;
//import java.util.stream.Collector;
//
///**
// * @author : zhangxiaobo
// * @version : v1.0
// * @description : 一句话描述该类的功能
// * @createTime : 2023/5/25 10:35
// * @updateUser : zhangxiaobo
// * @updateTime : 2023/5/25 10:35
// * @updateRemark : 说明本次修改内容
// */
//
//public class Examination {
//  public static void main(String[] args) {
//  }
//  private static int calculateASC(String s){
//    int result=0;
//    for (char c : s.toCharArray()) {
//      result +=c;
//    }
//    return result;
//  }
//  class foodCollection {
//    private int index;
//    private String name;
//    private int rate;
//  }
//  class cuisineCollection {
//    private int index;
//    private String name;
//    private int rate;
//    private PriorityQueue<foodCollection> food;
//  }
//  static Comparator<foodCollection> cmp = new Comparator<foodCollection>() {
//    @Override
//    public int compare(foodCollection e1, foodCollection e2) {
//      return e2.rate - e1.rate;
//    }
//  };
//  class FoodRatings {
//
//    private foodCollection[] foodCollections;
//
//    private cuisineCollection[] cuisineCollections;
//    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//      foodCollections = (foodCollection[]) new Object[foods.length];
//      cuisineCollections = (cuisineCollection[]) new Object[foods.length];
//      for (int i = 0; i < foods.length; i++) {
//        int index = calculateASC(foods[i]);
//        if (i==0){
//          foodCollections[i].name = foods[i];
//          foodCollections[i].index = index;
//          foodCollections[i].rate = ratings[i];
//        }else {
//          int start = 0;
//          int end =i;
//          //从小到大排序
//          if (foodCollections[i/2].index > index){
//            end = i/2;
//          }else {
//            start = i/2 +1;
//          }
//          for (int j = start;j < end; j++){
//            if (foodCollections[j].index > index){
//
//            }
//          }
//        }
//        int cuisined = cuisineContains(cuisines[i]);
//        if (cuisined == -1){
//          cuisineCollections[i].name = cuisines[i];
//          cuisineCollections[i].food = new PriorityQueue<>(cmp);
//          cuisineCollections[i].food.add(foodCollections[i]);
//        }else {
//          cuisineCollections[cuisined].food.add(foodCollections[i]);
//        }
//      }
//    }
//    private int cuisineContains(String s){
//      for (int i = 0; i < cuisineCollections.length; i++) {
//        if (cuisineCollections[i].equals(s)){
//          return i;
//        }
//      }
//      return -1;
//    }
//
//    public void changeRating(String food, int newRating) {
//      int asc = calculateASC(food);
//
//    }
//
//    public String highestRated(String cuisine) {
//
//    }
//  }
//
//}
