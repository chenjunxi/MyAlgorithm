package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
5
1 0 0 2 2
2 6 1 8 3
3 3 2 5 4
5 5 4 7 6
4 0 4 2 6

输出
1 2 3 4 5

首先定义一个灯类，包含编号，x=(x1+x2)/2,y=(y1+y2)/2,r=(x2-x1)/2 半径
存放在一个list中，按高低排序，y越低越高，所以list排序的时候自定义按照y进行升序排序
取一个元素，即是最高的等作为基准，遍历后面的灯
判断第二个灯和基准灯的高度差(y2-y1)<=r1,如果成立，就是统一行的灯，然后横坐标升序排序。
依次类推下去


* */
public class OD62_1 {
    static class Light {
        int id;
        int x;
        int y;
        int r;

        public Light(int id, int x, int y, int r) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Light[] lights = new Light[n];
        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            lights[i] = new Light(id, (x1 + x2) / 2, (y1 + y2) / 2, (x2 - x1) / 2);
        }

        // 纵坐标排序
        Arrays.sort(lights, (a, b) -> a.y - b.y);

        ArrayList<Light> same_row_lights = new ArrayList<>();
        Light base = lights[0];
        same_row_lights.add(base);

        String result = "";
        for (int i = 1; i < lights.length; i++) {
            Light light = lights[i];

            //是否小于半径
            if (light.y - base.y <= base.r) {
                same_row_lights.add(light);
            } else {
                // 横坐标排序
                same_row_lights.sort((a, b) -> a.x - b.x);
                for (int j = 0; j < same_row_lights.size(); j++) {
                    result += same_row_lights.get(j).id + " ";
                }
                same_row_lights.clear();

                base = light;
                same_row_lights.add(base);
            }
        }

        if (same_row_lights.size() > 0) {
            same_row_lights.sort((a, b) -> a.x - b.x);
            for (int i = 0; i < same_row_lights.size(); i++) {
                result += same_row_lights.get(i).id + " ";
            }
        }

        System.out.println(result.substring(0, result.length() - 1));
        return;
    }
}


