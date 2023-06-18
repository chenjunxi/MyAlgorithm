package com.leecode;

import java.util.Arrays;

/*
*
移到0
* */
public class leecode283 {
    public static void main(String[] args) {
        int[] num = {6, 1, 0, 3, 12};

        int index = 0;
        for (int i = 0; i < num.length; i++) {

            int i1 = num[i];
            if (i1 != 0) {
                swap(num, index++, i);
            }
        }

        System.out.println(Arrays.toString(num));
    }

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
