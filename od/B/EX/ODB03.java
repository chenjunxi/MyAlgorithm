package com.od.B.EX;

import java.util.Arrays;
import java.util.Scanner;

/*
*种树 需要记一下判断合法的逻辑

二分法
坑数组排序。第一个元素和最后一个元素分别是最小值和最大值
怎么判断合法，在指定距离，第二个位置距离前一个位置大于等于指定距离，直到最后一个位置，总共计划的树量>=给定的树苗，
就是合法

[left,right] mid合法的话 nas=mid 区间变成[mid+1,right],不合法区间变成[left,right-1]

7 坑的数量
1 3 6 7 8 11 13 每个坑的距离
3 需要种的树苗

7
1 3 6 7 8 11 13
3
输出6

* */
public class ODB03 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] sites = new int[n];
        for (int i = 0; i < n; i++) {
            sites[i] = in.nextInt();
        }

        int target = in.nextInt();

        System.out.println(maxDistance(sites, target));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }
}
