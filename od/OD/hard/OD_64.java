package com.od.OD.bei;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
/*二进制差异数
*
*
* */
//满分答案直接背。求出二进制位数，存放在32长度数组中。
public class OD_64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[32];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int h = Integer.toBinaryString(x).length();
            nums[h]++;
            ans += (i+1)-nums[h];
        }

        System.out.println(ans);

    }
}
