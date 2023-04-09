package com.od.OD.OD100;

import java.util.Scanner;

//题意是求第一次上报的时候，最大的积分是多少。
public class OD_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int length = s.length;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = Integer.parseInt(s[i]);
        }

        int count = ints[0];
        int max = ints[0];

        if (count >= 100) {
            System.out.println(100);  //若第一元素就大于100，就输出100
        } else {

            for (int i = 1; i < length; i++) {
                count += ints[i];
                if (count >= 100) {
                    max = Math.max(max, 100 - IndexCount(ints, i));
                } else {
                    max = Math.max(max, count - IndexCount(ints, i));
                }
            }
            System.out.println(max);
        }

    }

    public static int IndexCount(int[] arr, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += arr[i] * (index - i);
        }

        return sum;
    }
}
