package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD15 {
    public static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        int len = strings.length;
        int[] ints = new int[len];
        int count = 0;

        for (int i = 0; i < len; i++) {
            int temp = Integer.valueOf(strings[i]);
            ints[i] = temp;
            count += temp;
        }

        combine(ints, 5, new ArrayList<>(), 0);    //对篮球队员进行全排列

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            min = Math.min(Math.abs(count - nums.get(i) * 2), min);
        }

        System.out.println(min);
    }

    public static void combine(int[] s, int n, List<Integer> list, int index) {

        if (n == 0) {
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                res += list.get(i);
            }
            nums.add(res);
        } else {
            for (int i = index; i < s.length; i++) {
                list.add(s[i]);
                combine(s, n - 1, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
