package com.od.OD.OD130;

import java.util.Scanner;

/*
* 机器人
* 当相邻的网格的数字值差的绝对值小于等于1，即可认为可活动范围
* 求机器人在二维数组中可活动的最大范围
4 4
1 2 5 2
2 4 4 5
3 5 7 1
4 6 2 4
输出6

BFS 岛屿感染问题
* */
class OD_56 {
    public static int[][] region;
    public static int M;
    public static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        region = new int[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                region[i][j] = sc.nextInt();
            }
        }

        int max = 0;    //最大活动区域
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(region[i][j] != -1){
                    max = Math.max( max, move( i, j, region[i][j]));
                }
            }
        }

        System.out.println(max);
    }

    /**
     *
     * @param row   横坐标
     * @param col   纵坐标
     * @param num   上个网格的数字编号
     * @return      活动区域大小
     */
    public static int move(int row, int col, int num){

        if(row < 0 ||
                col < 0 ||
                row >= M ||
                col >= N
        ){
            return 0;   //越界了，返回0
        }

        int currentNum = region[row][col];
        if(currentNum == -1 ||      //已经统计过的网格
                Math.abs(currentNum - num) > 1){     //不符合绝对差值小于等于1
            return 0;
        }

        region[row][col] = -1;      //已经统计过的网格置为-1
        int count = 1;      //符合要求的网格统计1
        count += move( row - 1, col, currentNum);   //向上
        count += move( row + 1, col, currentNum);   //向下
        count += move( row, col - 1, currentNum);   //向左
        count += move( row, col + 1, currentNum);   //向右

        return count;
    }

}