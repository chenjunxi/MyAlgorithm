package com.od.OD.OD130;
/*
* 相同数字的积木游戏
*
* */
import java.util.Scanner;
public class OD_62 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = in.nextInt();
        }
        int max=-1;
        for(int i=0;i<num;i++){
            for(int j=i+1;j<num;j++){
                if(arr[i]==arr[j]){
                    max = Math.max(max,j-i);
                }
            }
        }

        System.out.println(max);
    }
}