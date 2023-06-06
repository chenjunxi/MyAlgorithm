package com.od.B.fenshu100;

import java.util.*;

/*
*两个数之和绝对值最小
-1 -3 7 5 11 15

0 1 23 4 5 6

-1 -2 -3 -4
输出-3 5 2
方法1：暴力循环
方法2：分组 -1和1 1和1 -1和-1
* */
public class OD36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        int[] ints = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        if (ints.length == 2) {
            Arrays.sort(ints);
            System.out.println(ints[0] + " " + ints[1] + " " + Math.abs(ints[0] + ints[1]));
            return;
        }


        for (int i = 0; i < ints.length; i++) {

            if (ints[i] >= 0) {
                list1.add(ints[i]);
            } else {
                list2.add(ints[i]);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);
        int size1 = list1.size();
        int size2 = list2.size();
        if (size1 != 0 && size2 != 0) {
            System.out.println(list2.get(0) + " " + list1.get(0) + " " + Math.abs(list2.get(0) + list1.get(0)));
        } else if (size2 == 0) {
            System.out.println(list1.get(0) + " " + list1.get(1) + " " + Math.abs(list1.get(1) + list1.get(0)));

        } else if (size1 == 0) {
            System.out.println(list2.get(size2 - 2) + " " + list2.get(size2 - 1) + " " + Math.abs(list2.get(size2 - 2) + list2.get(size2 - 1)));

        }

    }

    private static void demo(String[] s) {
        int[] num = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                int count = Math.abs(num[i] + num[j]);
                if (count < min) {
                    x = num[i];
                    y = num[j];
                    min = count;
                }
            }
        }
        System.out.print(x + " " + y + " " + min);
    }
}
