package com.od.OD.OD130;

import java.util.Scanner;

public class OD_40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = 0.0;
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String line = sc.nextLine();
            String[] split = line.split("\\d");
            for (String type : split) {
                if(!type.isEmpty()){
                    String num = line.substring(0, line.indexOf(type));
                    money += getCny(type, Double.parseDouble(num));
                    line = line.substring(line.indexOf(type) + type.length());
                }
            }
        }
        System.out.println(Math.round(Math.floor(money)));
    }

    private static double getCny(String type, double num) {
        switch (type) {
            case "CNY":
                return num * 100;
            case "fen":
                return num;
            case "JPY":
                return num / 1825 * 10000;
            case "sen":
                return num / 1825 * 100;
            case "HKD":
                return num / 123 * 10000;
            case "cents":
                return num / 123 * 100;
            case "EUR":
                return num / 14 * 10000;
            case "eurocents":
                return num / 14 * 100;
            case "GBP":
                return num / 12 * 10000;
            case "pence":
                return num / 12 * 100;
        }
        return 0;
    }
}
