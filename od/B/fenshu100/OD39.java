package com.od.B.fenshu100;

import java.util.Scanner;

public class OD39 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] a = new int[4];
        int[] b = new int[4];
        int[] c = new int[4];

        for (int i = 0; i < 4; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            c[i] = sc.nextInt();
        }

        int top = Math.min(a[1], Math.min(b[1], c[1]));       //上边界为三个坐标Y轴坐标的最小值
        int left = Math.max(a[0], Math.max(b[0], c[0]));      //左边界为三个坐标X轴坐标的最大值
        int down = Math.max(a[1] - a[3], Math.max(b[1] - b[3], c[1] - c[3]));       //下边界为三个坐标（Y轴坐标-高度）的最大值
        int right = Math.min(a[0] + a[2], Math.min(b[0] + b[2], c[0] + c[2]));      //右边界为三个坐标（X轴坐标+宽度）的最小值

        if (top > down && right > left) {
            System.out.println((top - down) * (right - left));  //高为（上边界-下边界）*宽为（右边界-左边界）
        } else {
            System.out.println(0);
        }
    }
}
