package com.od.B.fenshu100;

import java.util.Scanner;

public class OD27 {
    public static int N;
    public static int[] P;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int M = sc.nextInt();
        P = new int[N];
        //总共需要的盒饭个数
        int total = 0;
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
            total += P[i];
        }

        //最小出参速度
        int min = 0;
        //最大出参速度
        int max = total - M;
        while (min < max) {
            //二分法
            int mid = (min + max) / 2;
            if (outFood(mid, M)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }

    /**
     * 是否能正常出参
     *
     * @param speed 出参速度
     * @param foods 准备的盒饭个数
     * @return
     */
    public static boolean outFood(int speed, int foods) {

        boolean res = true;
        for (int i = 0; i < N; i++) {
            foods -= P[i];
            if (foods < 0) {
                res = false;
                break;
            }
            foods += speed;
        }

        return res;
    }
}
