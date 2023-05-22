package com.od.OD.OD130;

import java.util.Scanner;


//题意：M是一块芯片有M块资源(每一个资源是1.25G)，N是芯片数量，遍历第三行的配置，标记一块芯片上资源是否被占用
//如
/*
* 8：一块芯片有8个资源位
* 2：2块芯片
* ACABA
*
* 刚刚开始的时候，2块芯片上的资源上的0表示未被使用
* 0 0 0 0 0 0 0 0
* 0 0 0 0 0 0 0 0
*
* 思路：先统计2块芯片总被消耗多少资源，然后打印1或0
 * */
public class OD_105 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        String string = sc.nextLine();

        int[] chip = new int[N];    //板卡上的芯片
        int conf; //配置所占容量
        for(int i=0; i<string.length(); i++){
            char c = string.charAt(i);
            if(c == 'A'){
                conf = 1;
            }else if(c == 'B'){
                conf = 2;
            }else {
                conf = 8;
            }
            for(int j=0; j<N; j++){
                int used = chip[j];     //芯片占用的情况
                if(M - used >= conf){  //芯片所剩容量大于等于配置所占容量
                    chip[j] += conf;
                    break;
                }
            }
        }

        for(int i=0; i<N; i++){

            int used = chip[i];     //芯片占用的情况
            for(int j=0; j<M; j++){
                if(j<used){     //芯片占用的地方为1，未占用为0
                    System.out.print(1);
                }else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
