package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;
/*
* 数组限制数
*
* */
class OD_116_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        int  sum= in.nextInt();
        int[] balls = new int[nums];
        int[] org_balls = new int[nums];
        for (int i = 0; i < nums; i++) {
            balls[i] = in.nextInt();
            org_balls[i] = balls[i];
        }

        int total =  Arrays.stream(balls).sum();
        if (total <= sum) {
            System.out.println("[]");
            return;
        }
        Arrays.sort(balls);

        //二分法初始化
        int left = sum / nums;
        int right = balls[nums - 1];
        int[] result = new int[nums];
        for (int i = 0; i < nums; i++) {
            result[i] = org_balls[i] > left ? left : org_balls[i];
        }
        while (right > left+1){
            int mid = (right + left) / 2;

            int[] tmp = new int[nums];
            int temp_total = 0;
            for (int i = 0; i < balls.length; i++) {
                int r = org_balls[i] > mid ?  mid : org_balls[i];
                temp_total += r;
                tmp[i] = r;
            }

            if (temp_total > sum)
                right = mid;
            else if (temp_total < sum){
                left = mid;
                result = tmp;
            }
            else{
                result = tmp;
                break;
            }
        }
        Arrays.sort(result);
        System.out.println(result[nums-1]);
    }

}