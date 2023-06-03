package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
*原算法是满分，但实际有缺陷，一修复
100,500,300,200,400
输出3
100,100,150,150,200,300
输出2
50,100,200,200,250,300,400
输出3

思路：二分，0到数组大小，遍历，
判断原理：降序遍历文件数组，采用空闲容量升序减去文件大小，即最小空闲容量减去最大文件大小
* */
public class OD11 {
    public static int[] files;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        files = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(files);

        int min = 0;
        int max = files.length;

        while (min < max) {

            int mid = (min + max) / 2;
            if (check(mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        System.out.println(min);

    }

    public static boolean check(int mid) {

        int[] ints = new int[mid];
        for (int i = 0; i < mid; i++) {
            ints[i] = 500;
        }

        for (int i = files.length - 1; i >= 0; i--) {
            int f = files[i];
//            Arrays.sort(ints);

            boolean flag = false;
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] >= f) {
                    ints[j] -= f;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                return false;
            }

        }

        return true;
    }
}
