package com.od.OD.OD130;

import java.util.*;
//字符重新排序 100分
/*
This is an apple
an is This aelpp

* */
//排序--》map记录--》自定义排序
public class OD_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            String keya = a.getKey();
            String keyb = b.getKey();
            int valueA = a.getValue();
            int valueB = b.getValue();
            int lengthA = keya.length();
            int lengthB = keyb.length();


            if (valueA != valueB) return valueB - valueA;
            if (lengthA != lengthB) return lengthA - lengthB;

            return keya.compareTo(keyb);
        });


        for (int i = 0; i < list.size() - 1; i++) {
            int len = list.get(i).getValue();
            while (len > 0) {
                System.out.print(list.get(i).getKey() + " ");
                len--;
            }

        }
        System.out.println(list.get(list.size() - 1).getKey());
    }
}
