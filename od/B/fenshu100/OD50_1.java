package com.od.B.fenshu100;

import java.util.Scanner;

/*
* 经典保护屏
800*600范围
logo以x和y轴同时每秒一分像素移动，也就是45度角移动
0 0 10 初始位置和10秒，求10秒的坐标
10 10
* */
public class OD50_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int t = sc.nextInt();

        int xDirection = 1, yDirection = 1;
        int width = 800, height = 600;

        for (int i = 0; i < t; i++) {

            if (x == 0) {
                //碰到最上层，x轴方向开始向下
                xDirection = 1;
            }
            if (y == 0) {
                //碰到最左侧，y轴方向开始向右
                yDirection = 1;
            }
            if (x + 50 == width) {
                //碰到最右侧，x轴方向开始向左
                xDirection = -1;
            }
            if (y + 25 == height) {
                //碰到最下端，y轴方向向上
                yDirection = -1;
            }

            x += xDirection;
            y += yDirection;

        }

        System.out.println(x + " " + y);
    }
}
