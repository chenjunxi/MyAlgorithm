package com.od.OD.OD130;

import java.util.Scanner;
/*
*垃圾短信识别 100%
* 判断标准
1：A发送短信的接收者中，没有发过短信给A的人数L> 5;
2：A发送的短信数 -A接收的短信数M > 10;
3：如果存在X，A发送给X的短信数 - A接收到X的短信数N >5.
输入
15
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
1 11
1 12
1 13
1 14
14 1
1 15
1     判断id=1 是否是垃圾发送者
输出
true 13 13
说明
true 表示1是垃圾短信发送者，两个数字，代表发送者1对应的L和M值。
true 13 13中间以一个空格分割。
* */
class OD_90 {
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
