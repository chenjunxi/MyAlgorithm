package com.od.B.EX;

import java.util.Arrays;
import java.util.Scanner;

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
