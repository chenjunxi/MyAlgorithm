package com.leecode;

import java.util.ArrayList;

/*
 * 种花，位置调整问题
 *
 * */
public class leecode605 {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 1, 0, 0, 1, 0};
        int n = 1;


        //种花条件 自己为空 && 最左或者左边为空 && 最右或者右边为空

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                if (n == 0) {
                    System.out.println(true);
                    return;
                }
                flowerbed[i] = 1;
            }
        }

        System.out.println(false);

    }

    private static void demo(int[] flowerbed, int n) {
        //统计有多少个0

        boolean firstOne = true;
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (firstOne) {
                    if (count > 1) {
                        list.add(count - 1);
                    }
                    count = 0;
                    firstOne = false;
                } else if (count > 1) {
                    list.add(count - 2);
                    count = 0;
                }

            } else {
                count++;
            }

            if (i == flowerbed.length - 1 && count > 1) {
                list.add(firstOne ? count : count - 1);
            }

        }

        int sum = 0;
        for (int i : list) {
            sum += Math.ceil((double) i / 2);
        }
        System.out.println(sum >= n);
    }
}
