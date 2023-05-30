package com.od.OD.OD130;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*
* 相同数字组成图形的周长

2 2个数字
1 1 3 2 2 2 3 2 4 3 2 3 3 3 4 4 1 4 2 4 3 4 4 5 2 5 3 第一个元素是target值 剩下就是二维数组坐标
2 3 7 3 8 4 5 4 6 4 7 4 8 5 4 5 5 5 6 5 7 5 8 6 4 6 5 6 6 6 7 6 8 7 4 7 5 7 6 7 7 7 8
输出18 20 两个周长的值

思路：一个位置四边，判断某个边不等于target值，就是要统计的周长
固定二维数组64*64的，首先填充二维数组
遍历二维数组，计算周长，使用map记录
* */
public class OD_121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int[][] dp = new int[64][64];

        demo2(sc, N, dp);
    }

    //改进版，使用map，减少重复计算
    private static void demo2(Scanner sc, int n, int[][] dp) {
        int[] ints = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        //填充二维数组
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int[] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            int target = nums[0];
            ints[i] = target;
            map.put(target, 0);
            for (int j = 1; j < nums.length; j += 2) {
                dp[nums[j]][nums[j + 1]] = target;
            }
        }

        //遍历二维数组，计算周长，使用map记录
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {

                int key = dp[i][j];
                if (map.containsKey(key)) {
                    Integer temp = map.get(key);
                    //关键计算周长逻辑
                    if (i == 0 || dp[i - 1][j] != key) temp++;
                    if (i == 63 || dp[i + 1][j] != key) temp++;
                    if (j == 0 || dp[i][j - 1] != key) temp++;
                    if (j == 63 || dp[i][j + 1] != key) temp++;
                    map.put(key, temp);
                }
            }
        }

        for (int i = 0; i < ints.length; i++) {

            System.out.print(map.get(ints[i]));
            if (i!= n -1){
                System.out.print(" ");
            }
        }
    }

    //原始版
    private static void demo(Scanner in, int n, int[][] matrix) {
        Integer[][] input_datas = new Integer[n][];
        for (int i = 0; i < n; i++) {
            input_datas[i] = Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            int target = input_datas[i][0];
            for (int j = 1; j < input_datas[i].length; j += 2) {
                matrix[input_datas[i][j]][input_datas[i][j + 1]] = target;
            }
        }

        //保存结果
        int[] result = new int[n];
        for(int k = 0; k< n; k++){
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

        for(int i = 0; i< n; i++){
            System.out.print(result[i]);
            if (i!= n -1){
                System.out.print(" ");
            }
        }
    }

}
