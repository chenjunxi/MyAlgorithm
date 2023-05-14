package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
* 称砝码
2 砝码数量
1 2 重量1 重量2
2 1 重量1砝码个数为2 重量2砝码个数为1
* */
public class OD_118 {
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