package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
* 最大直角三角形
1 1组测试数据
7 3 4 5 6 5 12 13
输出2
* */
class OD_110 {
    public static ArrayList<Integer> result = new ArrayList<>();
    public static ArrayList<Integer[]> paths = new ArrayList<>();
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        // 处理输入
        int T = in.nextInt();
        for (int i=0;i<T;i++) {
            int N = in.nextInt();
            int[] nums = new int[N];
            for (int j = 0; j < N; j++) {
                nums[j] = in.nextInt();
            }

            Arrays.sort(nums);
            System.out.println(dfs(nums,0));
        }
    }

    public static int dfs(int[] lines, int index) {
        int maxVal = 0;
        int a, b, c;
        for (int i = index; i < lines.length-2; i++) {
            a = lines[i];
            if (a == 0) {
                continue;
            }
            for (int j = i+1; j < lines.length-1; j++) {
                b = lines[j];
                if (b == 0) {
                    continue;
                }
                for (int k = j+1; k < lines.length; k++) {
                    c = lines[k];
                    if (c == 0) {
                        continue;
                    }
                    if ((a*a + b*b) == c*c) {
                        lines[i]=0;
                        lines[j]=0;
                        lines[k]=0;
                        maxVal = Math.max(maxVal, dfs(lines,i+1) +1);
                        lines[i]=a;
                        lines[j]=b;
                        lines[k]=c;
                    };
                }
            }
        }

        return maxVal;
    }


}