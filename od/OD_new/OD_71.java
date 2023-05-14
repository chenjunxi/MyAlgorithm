package com.od.OD.OD130;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
* 计算网络信号
0表示空旷位置，-1表示阻隔物 数字表示信号源，信号源上下左右衰减1
输入为三行，
第一行为m n，代表输入是一个m*n的数组
第二行是一串m*n个用空格分隔的整数。每连续n个数代表一行，再往后n个代表下一行，以此类推。对应的值代表对应的网格是空旷位置，还是信号源，还是阻隔物
第三行是i j，代表需要计算array[i][j]的网络信号值，注意：此处i和j均从0开始，即第一行i为0
例如：

6 5
0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
1 4
输出(1,4)信号值
输出2
* */
public class OD_71 {
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
                    sites.addLast(new int[]{i, j, num});
                }
            }
        }
        String[] strslast = sc.nextLine().split(" ");
        int x = Integer.parseInt(strslast[0]);
        int y = Integer.parseInt(strslast[1]);

        boolean[][] isused = new boolean[m][n];
        int[][] df = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
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
                    if (newx >= 0 && newx < m && newy >= 0 && newy < n && !isused[newx][newy] && nums[newx][newy] != -1) {
                        isused[newx][newy] = true;
                        nums[newx][newy] = sitevalue - 1;
                        sites.add(new int[]{newx, newy, sitevalue - 1});
                    }
                }
            }
        }

        System.out.println(nums[x][y]);
    }
}
