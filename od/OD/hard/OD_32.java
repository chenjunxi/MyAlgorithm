package com.od.OD.bei;

import java.util.ArrayList;
import java.util.Scanner;
/*选择核酸点
10 30 开始时间10点30分
14 50 要求完成时间
3 3个核酸点
1 10 19 1为核酸点ID 10公里(1公里花费10元和10分钟) 19当前核酸点排队人数
2 8 20
3 21 2

输出
2
2 80 80 ID 时间 花费
1 190 100
求出在指定时间内能完成核酸的核酸点，如果有多个，时间最少排在前面，然后是金钱花费最少的，如果时间和金钱都一样，id小的排在前面


* */
public class OD_32 {
    public static int hour_08 = 8 * 60;
    public static int hour_10 = 10 * 60;
    public static int hour_12 = 12 * 60;
    public static int hour_14 = 14 * 60;
    public static int hour_18 = 18 * 60;
    public static int hour_20 = 20 * 60;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int starTime = sc.nextInt() * 60 + sc.nextInt();
        int finshTime = sc.nextInt() * 60 + sc.nextInt();

        int diffTime = finshTime - starTime;

        ArrayList<Hesuan> list = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(new Hesuan(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        ArrayList<Hesuan> listRes = new ArrayList<>();

        for (Hesuan item : list) {
//            System.out.println(item.id + " " + item.instance + " " + item.personnums);

            int instanceTime = item.instance * 10;
            int personnums = item.personnums;

            int starTempTime = starTime;
            int count = 1;
            for (int i = 1; i <= instanceTime-1; i++) {
                starTempTime += 1;

                if (hour_08 <= starTempTime && starTempTime <= hour_20) {

                    if (hour_08 <= starTempTime && starTempTime <= hour_10) {
                        personnums += 3;
                    } else if (hour_12 <= starTempTime && starTempTime <= hour_14) {
                        personnums += 10;
                    } else if (hour_18 <= starTempTime && starTempTime <= hour_20) {
                        personnums += 20;
                    } else if (count == 5) {
                        count = 1;
                        personnums += 1;
                    } else {
                        count++;
                    }
                    if (personnums > 0) personnums--;
                }
            }

            int cost = item.instance * 10;


            int totalTime = instanceTime + personnums;
            if (totalTime < diffTime) {
                listRes.add(new Hesuan(item.id, cost, totalTime));
            }

        }

        listRes.sort((h1, h2) -> {
            if (h1.personnums != h2.personnums) return h1.personnums - h2.personnums;
            if (h1.instance != h2.instance) return h1.instance - h2.instance;
            return h1.id - h2.id;
        });


        for (Hesuan item : listRes) {
            System.out.println(item.id + " " + item.instance + " " + item.personnums);
        }
    }

    static class Hesuan {
        public int id;
        public int instance;
        public int personnums;

        public Hesuan(int id, int instance, int personnums) {

            this.id = id;
            this.instance = instance;
            this.personnums = personnums;
        }
    }
}
