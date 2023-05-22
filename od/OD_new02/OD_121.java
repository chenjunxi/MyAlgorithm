package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;
/*
* 相同数字组成图形的周长
一个正方形只要某一面不是本身值就加入周长
2 2个数字
1 1 3 2 2 2 3 2 4 3 2 3 3 3 4 4 1 4 2 4 3 4 4 5 2 5 3 第一个元素是值 剩下就是坐标
2 3 7 3 8 4 5 4 6 4 7 4 8 5 4 5 5 5 6 5 7 5 8 6 4 6 5 6 6 6 7 6 8 7 4 7 5 7 6 7 7 7 8
输出18 20 两个周长的值
* */
public class OD_121 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[64][64]; //固定值

        Integer[][] input_datas = new Integer[N][];
        for (int i = 0; i < N; i++) {
            input_datas[i] = Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            int target = input_datas[i][0];
            for (int j = 1; j < input_datas[i].length; j += 2) {
                matrix[input_datas[i][j]][input_datas[i][j + 1]] = target;
            }
        }

        //保存结果
        int[] result = new int[N];
        for(int k=0;k<N;k++){
            int temp_res = 0;
            int target = input_datas[k][0];
            for (int i = 0; i < 64; i++) {
                for (int j = 0; j < 64; j++) {
                    if (matrix[i][j] == target) {
                        if (i == 0 || matrix[i - 1][j] != target) temp_res++;
                        if (i == 63 || matrix[i + 1][j] != target) temp_res++;
                        if (j == 0 || matrix[i][j - 1] != target) temp_res++;
                        if (j == 63 || matrix[i][j + 1] != target) temp_res++;
                    }
                }
            }
            result[k]=temp_res;
        }

        for(int i=0;i<N;i++){
            System.out.print(result[i]);
            if (i!=N-1){
                System.out.print(" ");
            }
        }
    }

}
