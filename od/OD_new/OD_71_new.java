package com.od.OD.OD130;

import java.util.ArrayDeque;
import java.util.Scanner;
/*
* 计算网络信号
*
* */
public class OD_71_new {
    public static void main(String[] args) {
        ArrayDeque<int[]> sites = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        int[][] nums = new int[m][n];
        int start = 0;
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(s[start++]);
                nums[i][j] = num;
                if (num > 0) {
                    sites.addLast(new int[] {i, j, num});
                }
            }
        }
        String[] strslast = sc.nextLine().split(" ");
        int x = Integer.parseInt(strslast[0]);
        int y = Integer.parseInt(strslast[1]);

        boolean[][] isused = new boolean[m][n];
        int[][] df = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!sites.isEmpty()) {
            int[] ints = sites.pollFirst();
            int sitex = ints[0];
            int sitey = ints[1];
            int sitevalue = ints[2];
            isused[sitex][sitey] = true;
            if (sitevalue > 1) {
                for (int i = 0; i < 4; i++) {
                    int newx = sitex + df[i][0];
                    int newy = sitey + df[i][1];
                    if (newx >= 0 && newx < m && newy >=0 && newy < n && !isused[newx][newy] && nums[newx][newy] != -1) {
                        isused[newx][newy] = true;
                        nums[newx][newy] = sitevalue-1;
                        sites.add(new int[] {newx, newy, sitevalue-1});
                    }
                }
            }
        }

        System.out.println(nums[x][y]);
    }
}
