package com.od.OD.OD130;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
* Linux发行版的数量
* */
class OD_101_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = in.nextInt();
            }
        }

        //关联过的linux版本
        Set<Integer> linux_version = new HashSet<>();
        int result = 0;
        for(int i=0; i<n; i++){
            if(!linux_version.contains(i)){
                //当前版本集
                Set<Integer> current_version_set = new HashSet<>();
                check(current_version_set, i, matrix);
                result = Math.max(result, current_version_set.size());
                linux_version.addAll(current_version_set);
            }
        }

        System.out.println(result);
    }

    public static void check(Set<Integer> current_version_set, int n, int[][] matrix){

        for(int i=0; i<matrix.length; i++){
            if(current_version_set.contains(i)){
                continue;
            }
            if(n != i && matrix[n][i] == 1){
                current_version_set.add(i);
                check(current_version_set, i,matrix);
            }
        }

    }

}