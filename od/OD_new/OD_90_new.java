package com.od.OD.OD130;

import java.util.Scanner;
/*
*垃圾短信识别
*
* */
class OD_90_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] id_pairs = new int[n][2];
        int[][] data = new int[100][100];
        for (int i = 0; i < n; i++) {
            id_pairs[i][0] = in.nextInt();
            id_pairs[i][1] = in.nextInt();
            data[id_pairs[i][0]][id_pairs[i][1]]+=1;
        }

        int id = in.nextInt();

        int L=0;
        int M1=0;
        int M2=0;
        boolean flag = false;
        for(int i=0;i<100;i++){
            if(data[id][i]>0 && data[i][id]==0){
                L++;
            }
            M1+=data[id][i];
            M2+=data[i][id];
            if(data[id][i]-data[i][id] > 5){
                flag = true;
            }
        }
        if(L>5 || M1-M2>10){
            flag = true;
        }

        System.out.println(flag + " " + L + " " + (M1-M2));

    }

}
