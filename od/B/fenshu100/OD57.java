package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OD57 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(",");

        int max = 0;
        for (int i = 0; i < strings.length; i++) {

            String str1 = strings[i];
            int len1 = str1.length();

            for (int j = i + 1; j < strings.length; j++) {
                //set可以去重
                Set<String> set = new HashSet<>();
                set.addAll(Arrays.asList(str1.split("")));

                String str2 = strings[j];
                int len2 = str2.length();
                set.addAll(Arrays.asList(str2.split("")));

                if (set.size() == len1 + len2) {
                    //去重之后的长度等于去重前的长度之和，说明没有重复元素
                    max = Math.max(max, len1 * len2);
                }
            }
        }

        System.out.println(max);
    }

}
