package com.od.OD.OD200;

import java.util.ArrayList;
import java.util.Scanner;

public class OD_46 {

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
