package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.Scanner;

public class OD01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        //苹果数组
        int[] apples = new int[num];
        for(int i=0; i<num; i++){
            apples[i] = sc.nextInt();
        }

        //求出所有苹果的异或值
        int count = apples[0];
        for(int i=1; i<num; i++){
            count ^= apples[i];
        }

        int res = -1;
        if(count == 0){
            //异或值等于0说明满足A的分苹果方案
            //苹果中最小的重量
            int min = Arrays.stream(apples).min().getAsInt();
            //所有苹果的总重量
            int total = Arrays.stream(apples).sum();
            res = total - min;
        }

        System.out.println(res);
    }

}
