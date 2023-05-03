package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;
/*
* 相同数字组成图形的周长
* */
public class OD_121_new {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[64][64];

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
