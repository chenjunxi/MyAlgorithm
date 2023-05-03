package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;
/*
* 统计友好度最大值
*
* */
class OD_82 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        Integer[] seats = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int result=0,left=0,right=0;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                left++;
            }
            else if(seats[i]==2){
                left=0;
            }
            else if(seats[i]==0){
                for(int j=i+1;j<seats.length;j++){
                    if(seats[j]==1){
                        right++;
                    }
                    else if(seats[j]==0 || seats[j]==2){
                        break;
                    }
                }
                if(result<left+right){
                    result=left+right;
                }
                right=0;
                left=0;
            }
        }

        System.out.println(result);
    }

}