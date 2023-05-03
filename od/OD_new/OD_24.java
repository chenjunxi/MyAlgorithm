package com.od.OD.OD130;

import java.util.Scanner;

/*
* 数组中心位置
*
* */

//左前缀积 和 右后缀积
//再考虑 特殊情况 ： N 1 1 1 1 和 1 1 1 1 N
public class OD_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        int length = s.length;

        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = Integer.parseInt(s[i]);
        }
        if (length == 0) {
            System.out.println("-1");
            return;
        }
        if (length == 1) {
            System.out.println("0");
            return;
        }

        int[] arrLeft = new int[length];
        int[] arrRight = new int[length];

        arrLeft[0] = ints[0];
        for (int i = 1; i < length; i++) {
            arrLeft[i] = ints[i] * arrLeft[i - 1];
        }

        arrRight[length - 1] = ints[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            arrRight[i] = ints[i] * arrRight[i + 1];
        }

        boolean flag = false;
        if (arrRight[1] == 1) { // N 1 1 1 1 情况
            System.out.println("0");
        } else {
            for (int i = 1; i < length; i++) {

                if (i == length - 1) {  // 1 1 1 1  N
                    if (arrLeft[length - 2] == 1) {
                        System.out.println(i);
                        return;
                    }
                }

                int left = arrLeft[i - 1];
                int right = arrRight[i + 1];


                if (left == right) {
                    System.out.println(i);
                    flag = true;
                    break;
                } else if (left > right) {
                    System.out.println("-1");
                    break;
                }
            }
            if (false) {
                System.out.println("-1");
            }
        }

    }

    public static int IndexJi(int[] arr, int index, Boolean flag) {

        if (flag) {
            if (index == 1) {
                return arr[0];
            }
            int res = arr[0];
            for (int i = 1; i < index; i++) {
                res = arr[i] * res;
            }
            return res;
        } else {
            if (index == arr.length - 2) {
                return arr[arr.length - 1];
            }
            int res = arr[index + 1];
            for (int i = index + 2; i < arr.length; i++) {
                res = arr[i] * res;
            }
            return res;
        }


    }
}
