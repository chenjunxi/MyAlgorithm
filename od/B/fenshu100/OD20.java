package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OD20 {
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(",");

        int slen = strings.length;
        int res;

        if (slen == 1) {    //考虑到只有一个数的情况
            res = Integer.valueOf(strings[0]);
        } else {
            List<Integer> numList = new ArrayList<>();

            for (int i = 0; i < slen; i++) {
                numList.add(Integer.valueOf(strings[i]));
            }
            Collections.sort(numList);  //对数组进行排序
            int numsLen;
            if (slen == 2) {    //区别只有两个数的情况
                numsLen = 2;
            } else {
                numsLen = 3;
            }

            int[] ints = new int[numsLen];
            for (int i = 0; i < numsLen; i++) {
                ints[i] = numList.get(i);
            }
            fullArr(ints, 0, numsLen);   //对数字进行全排列找出最小值

            res = Collections.min(list);
        }
        System.out.println(res);
    }

    /**
     * 对ints中的数字进行全排列
     *
     * @param ints
     * @param cursor
     * @param end
     */
    public static void fullArr(int[] ints, int cursor, int end) {

        if (cursor == end) {
            String s = "";
            for (int i : ints) {
                s += i;
            }
            list.add(Integer.parseInt(s));
        } else {
            for (int i = cursor; i < end; i++) {
                swap(ints, cursor, i);
                fullArr(ints, cursor + 1, end);
                swap(ints, cursor, i);
            }
        }
    }

    public static void swap(int[] ints, int a, int b) {

        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;

    }
}
