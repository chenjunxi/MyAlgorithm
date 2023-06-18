package com.leecode;

import java.util.Arrays;

/*
*
拥有最多糖果的孩子
* */
public class leecode1431 {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        int max = Arrays.stream(candies).max().getAsInt();
        int i = max - extraCandies;

        if (i <= 0) {
            for (int j = 0; j < candies.length; j++) {
                System.out.print("true" + ",");
            }
        } else {
            for (int j = 0; j < candies.length; j++) {
                if (candies[j] >= i) {
                    System.out.print("true" + ",");
                }else {
                    System.out.print("false" + ",");
                }
            }
        }

    }
}
