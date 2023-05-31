package com.od.OD.OD130;

import java.util.Scanner;
//excel单元值计算
// 循环指定范围的所有值，累加
//计算函数 ,单元值获取坐标函数，递归回溯
public class OD_63 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        String[][] items = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            items[i] = sc.nextLine().split(" ");
        }

        String line = sc.nextLine();
        String[] split = line.split(":");
        int startY = getIndex(split[0])[1];
        int startX = getIndex(split[0])[0];
        int endY = getIndex(split[1])[1];
        int endX = getIndex(split[1])[0];

        int sum = 0;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                sum += evaluate(items, i, j);
            }
        }
        System.out.println(sum);
    }

    //三种情况
    private static int evaluate(String[][] items, int i, int j) {

        String s = items[i][j];
        if (s.startsWith("=")) {
            int res;
            s = s.substring(1);
            int indexPlus = s.indexOf("+");
            if (indexPlus > 0) { //加法
                String val01 = s.substring(0, indexPlus);
                String val02 = s.substring(indexPlus + 1);
                int value1 = getValue(items, val01);
                int value2 = getValue(items, val02);
                res = value1 + value2;
            } else {
                int indexMinus = s.indexOf("-");
                if (indexMinus > 0) { //减法
                    String val01 = s.substring(0, indexMinus);
                    String val02 = s.substring(indexMinus + 1);
                    res = getValue(items, val01) - getValue(items, val02);
                } else { //只有单元格
                    int[] index = getIndex(s);
                    res = evaluate(items, index[0], index[1]);
                }
            }

            items[i][j] = String.valueOf(res); //赋值为数字,减少后续重复计算
            return res;
        } else {
            return Integer.parseInt(s);
        }
    }

    public static int getValue(String[][] items, String s) {
        int num;
        if (Character.isDigit(s.charAt(0))) {//判断是否是数字开头，即可认为是否是数字
            num = Integer.parseInt(s);
        } else { //如果是单元值就递归回溯查找
            int[] index = getIndex(s);
            num = evaluate(items, index[0], index[1]);
        }
        return num;
    }

    //根据单元转成坐标
    public static int[] getIndex(String s) {
        int x = Integer.parseInt(s.substring(1)) - 1;
        int y = s.charAt(0) - 'A';
        return new int[]{x, y};
    }


}
