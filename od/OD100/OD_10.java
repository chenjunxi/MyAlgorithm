package com.od.OD.OD100;

import java.util.Scanner;

public class OD_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double money = 0.0;


        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] split = line.split("\\d");

            for (String type : split) {
                if (!type.isEmpty()) {

                    String num = line.substring(0, line.indexOf(type));
                    money += getCny(type, Double.parseDouble(num));
                    line = line.substring(line.indexOf(type), line.length());
                }
            }

        }
    }

    private static double getCny(String type, double num) {

        switch (type){
            case "CYN":
                
                return num*100;
        }

        return 0;
    }
}
