package com.leecode.base;

import scala.Int;

import java.util.ArrayList;

/*

两个数组的交集
* */
public class Day03_HaspTable02 {
    public static void main(String[] args) {

        int[] a = {1, 2, 1, 2};
        int[] b = {2, 2};

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            for (int j = 0; j < b.length; j++) {
                if (i1 == b[j]) {
                    list.add(i1);
                }
            }
        }

        //改进方法使用map记录数字

    }
}
