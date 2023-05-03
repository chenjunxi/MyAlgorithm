package com.od.OD.OD130;

import java.util.Scanner;
/*
*购买水果最便宜的方案
* */
class OD_126_new {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] min_price = new int[n+1];
        for (int i=1;i<=n;i++){
            min_price[i] = Integer.MAX_VALUE;
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a=in.nextInt();
            int b=in.nextInt();
            int c=in.nextInt();
            for (int j=a;j<=b;j++){
                if (min_price[j]>c){
                    min_price[j] = c;
                }
            }
        }
        int sum=0;
        for (int i=1;i<=n;i++){
            sum+=min_price[i];
        }
        System.out.println(sum);
    }
}