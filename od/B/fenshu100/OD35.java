package com.od.B.fenshu100;

import java.util.Scanner;

public class OD35 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(";");

        int length = strings.length;
        String[] bl = strings[length - 3].split(","); //不等式变量
        String[] mb = strings[length - 2].split(","); //不等式目标值
        String[] ys = strings[length - 1].split(","); //不等式约束

        int m = ys.length;  //约束的数量等于数组的数量
        int n = bl.length;  //变量的数量等于数组中数据的数量

        Double[] mubiao = new Double[m];    //目标值的数量等于约束的数量
        int[] bianliang = new int[n];

        for (int i = 0; i < m; i++) {
            mubiao[i] = Double.valueOf(mb[i]);  //不等式目标转换成double类型
        }
        for (int i = 0; i < n; i++) {
            bianliang[i] = Integer.valueOf(bl[i]);  //不等式变量装换成int类型
        }

        double[][] doubles = new double[m][n];  //不等式系数是二维数组

        for (int i = 0; i < m; i++) {
            String[] xs = strings[i].split(","); //不等式系数
            for (int j = 0; j < n; j++) {
                doubles[i][j] = Double.parseDouble(xs[j]);  //将不等式系数放入double类型二维数组
            }
        }

        boolean isYueshu = true;
        double max = 0;

        for (int i = 0; i < m; i++) {  //循环遍历不等式数组
            double d = 0;
            boolean b = true;
            for (int j = 0; j < n; j++) {
                d += doubles[i][j] * bianliang[j];   //不等式数组值
            }
            max = Math.max(max, d - mubiao[i]);    //求出最大差
            if (ys[i].equals(">")) {  //等于不等式进行判断
                b = d > mubiao[i];
            } else if (ys[i].equals(">=")) {
                b = d >= mubiao[i];
            } else if (ys[i].equals("<")) {
                b = d < mubiao[i];
            } else if (ys[i].equals("<=")) {
                b = d <= mubiao[i];
            } else if (ys[i].equals("=")) {
                b = d == mubiao[i];
            }
            if (!b) { //只要一个等式不成立就为false
                isYueshu = false;
            }
        }

        System.out.println(isYueshu + " " + (int) max);
    }
}
