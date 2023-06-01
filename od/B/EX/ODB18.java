package com.od.B.EX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ODB18 {
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


