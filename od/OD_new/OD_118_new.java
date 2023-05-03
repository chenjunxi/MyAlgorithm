package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
/*
* 称砝码
* */
public class OD_118_new {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            HashSet<Integer> set = new HashSet<>();
            set.add(0);
            int n = in.nextInt();
            int[] w = new int[n];
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                w[i] = in.nextInt();
            }
            for(int i=0;i<n;i++){
                nums[i] = in.nextInt();
            }
            for(int i=0;i<n;i++){
                ArrayList<Integer> current_res = new ArrayList<>(set);
                for(int j=1;j<=nums[i];j++){
                    for(int k=0;k<current_res.size();k++){
                        set.add(current_res.get(k) + w[i] * j);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}