package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.Scanner;
/*
* 服务中心选址
* */
//不会做，题意理解不了。寻找最近的中心服务站
public class OD_108_new {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            list.add(new int[]{left, right});
        }

        //对区域进行排序，
        list.sort((left, right) -> {
            if (left[0] == right[0]) return left[1] - right[1];
            return left[0] - right[0];
        });

        int leftmin = list.get(0)[0];
        int rightmax = list.get(n - 1)[1];


//        暴力计算
//        demo(list, leftmin, rightmax);

        demo01(list, leftmin, rightmax);

    }

    //二分查找思想
    private static void demo01(ArrayList<int[]> list, int leftmin, int rightmax) {
        int leftInstance = getMix(leftmin, list);
        int rightInstance = getMix(rightmax, list);

        while (rightmax - leftmin > 1) {
            int middle = (rightmax + leftmin) / 2;
            int midInstance = getMix(middle, list);
            int min = Math.min(leftInstance, rightInstance);
            if (leftInstance == min) {
                rightInstance = midInstance;
                rightmax = middle;
            } else {
                leftInstance = midInstance;
                leftmin = middle;
            }
        }

        System.out.println(Math.min(leftInstance, rightInstance));
    }

    private static void demo(ArrayList<int[]> list, int leftmin, int rightmax) {
        int result = Integer.MAX_VALUE;
        for (int i = leftmin; i <= rightmax; i++) {

            int mix = getMix(i, list);
            result = Math.min(result, mix);
        }

        System.out.println(result);
    }

    public static int getMix(int index, ArrayList<int[]> list) {

        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            int left = ints[0];
            int right = ints[1];


            if (index < left) {
                total += left - index;
            } else if (right < index) {
                total += index - right;
            }
        }
        return total;
    }


}
