package com.od.OD.OD130;

import java.util.*;

/*
* 检测热点字符 增量统计比较
* 思路：使用map记录字符出现次数，然后每M个就统计输出一次。
3 10 aaagggbcce9999333213gggggaaaaa ->
5 10 1234567890


每次10个字符，出现次数前3个，

* */
public class OD_115 {
    public static int min_num;

    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        String str = sc.next();

        StringBuilder sb = new StringBuilder();

        int index = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            index++;

            if (index == M || i == str.length() - 1) {
                check(N, sb, map, i);
                index = 0;
            }


        }

        System.out.println(sb.toString());

    }

    private static void check(int n, StringBuilder sb, HashMap<Character, Integer> map, int i) {
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            Integer av = a.getValue();
            Integer bv = b.getValue();

            if (av != bv) return bv - av;
            return -a.getKey().compareTo(b.getKey());
        });

        n = Math.min(list.size(), n);
        for (int j = 0; j < n; j++) {
            sb.append(list.get(j).getKey());
        }
    }
}