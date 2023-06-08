package com.od.B.fenshu100;

import java.util.*;

/*
*恢复数字序 逻辑题 重要方法判断两个map是否一致，map中统计字符个数加减
给定一个已打乱的字符串，要求恢复连续正整数的序列，并且给定恢复后的整数个数，输出序列中最小的数字

19801211 5
输出8
正常序列为 8 9 10 11 12

* */
public class OD63 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input_str = in.next();
        int length = in.nextInt();
        int sumLen = input_str.length();

        HashMap<Character, Integer> origin_char_map = new HashMap<>();
        for (int i = 0; i < input_str.length(); i++) {
            char c = input_str.charAt(i);
            origin_char_map.put(c, origin_char_map.getOrDefault(c, 0) + 1);
        }

        //全都是个位数
        if (length == sumLen) {
            int[] ints = new int[length];
            for (int i = 0; i < length; i++) {
                ints[i] = input_str.charAt(i) - '0';
            }
            Arrays.sort(ints);

            System.out.println(ints[0]);
        }

        float N = sumLen;
        float M = length;
        float v = N / M;

        //个位、2位数组合
        if (v > 1 && v < 2) {
            int twoNum = (int) (N % M); //两位数
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < twoNum; i++) {
                list.add(10 + i);
            }
            int onwNum = (int) (M - twoNum); //个位数
            for (int i = 0; i < onwNum; i++) {

                list.add(9 - i);
            }
            list.sort(Comparator.naturalOrder());
            System.out.println(list.get(0));
        }


        //2位数以上，滑窗思想，判断依据是两个map统计一模一样
        if (v >= 2) {
            HashMap<Character, Integer> window_char_map = new HashMap<>();
            for (int i = 10; i < (length + 10); i++) {
                countNumChar(i + "", window_char_map, true);
            }

            if (cmp(origin_char_map, window_char_map)) {
                System.out.println(10);
                return;
            }


            for (int i = 11; i <= 1000 - length + 1; i++) {
                String remove = i - 1 + "";
                countNumChar(remove, window_char_map, false);

                String add = i + length - 1 + "";
                countNumChar(add, window_char_map, true);

                if (cmp(origin_char_map, window_char_map)) {
                    System.out.println(i);
                    return;
                }
            }


        }


    }


    public static void countNumChar(String num, HashMap<Character, Integer> window_char_map, boolean isAdd) {
        for (int j = 0; j < num.length(); j++) {
            char c = num.charAt(j);
            window_char_map.put(c, window_char_map.getOrDefault(c, 0) + (isAdd ? 1 : -1));
        }
    }

    public static boolean cmp(HashMap<Character, Integer> origin_char_map, HashMap<Character, Integer> window_char_map) {
        for (Character c : origin_char_map.keySet()) {
            if (!window_char_map.containsKey(c) || window_char_map.get(c) - origin_char_map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
