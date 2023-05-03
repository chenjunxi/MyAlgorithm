package com.od.OD.OD130;

import java.util.Scanner;

//商场优惠活动

/*
思路：
暴力枚举所有类型：先满减后打折 先打折后满减 先满减后无门槛 先打折后无门槛 先无门槛后打折
满减函数：先money/100,求出张数，money-10*张数
3 2 5
3
100
200
400

* */

public class OD_14 {

    public static int manjian;
    public static int dazhe;
    public static int wumenkan;
    //券的最小使用量
    public static int mincountQuan;
    //最少价格
    public static int minCount;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        manjian = sc.nextInt();
        dazhe = sc.nextInt();
        wumenkan = sc.nextInt();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            double money = sc.nextInt();
            mincountQuan = Integer.MAX_VALUE;
            minCount = Integer.MAX_VALUE;
            //有打折的情况下
            if (dazhe >= 1) {
                manjiandazhe(money);
                dazhemanjian(money);
                dazhewumenkan(money);
                wumenkandazhe(money);
            }
            manjianwumenkan(money);
            System.out.println(minCount + " " + mincountQuan);
        }
    }

    public static void update(int quanCount, int moneyCount) {
        if (moneyCount < minCount) {
            minCount = moneyCount;
            mincountQuan = quanCount;
        } else if (moneyCount == minCount) {
            mincountQuan = mincountQuan > quanCount ? quanCount : mincountQuan;
        }
    }

    public static int getManjianQuan(double money) {
        return money / 100 >= manjian ? manjian : (int) (money / 100);
    }

    public static int getWumenkanQuan(double money) {
        for (int i = 1; i <= wumenkan; i++) {
            if (money <= 5 * i) {
                return i;
            }
        }
        return wumenkan;
    }

    //    先满减后打折
    public static void manjiandazhe(double money) {
        int count = getManjianQuan(money);

        int afterMoney = (int) Math.floor((money - count * 10) * 0.92);

        update(count + 1, afterMoney);
    }

    //    先打折后满减
    public static void dazhemanjian(double money) {
        double v = money * 0.92;
        int count = getManjianQuan(v);

        int afterMoney = (int) Math.floor(v - count * 10);
        update(count + 1, afterMoney);
    }
//    先打折后无门槛

    public static void dazhewumenkan(double money) {
        double v = money * 0.92;
        int count = getWumenkanQuan(v);
        int afterMoney = v <= count * 5 ? 0 : (int) Math.floor(v - count * 5);
        update(count + 1, afterMoney);
    }


    //    先无门槛后打折
    public static void wumenkandazhe(double money) {
        int count = getWumenkanQuan(money);
        if (money <= count * 5) {
            update(0, count);
        } else {
            int afterMoney = (int) Math.floor((money - count * 5) * 0.92);
            update(count + 1, afterMoney);
        }
    }

    //    先满减后无门槛
    public static void manjianwumenkan(double money) {
        int mjCount = getManjianQuan(money);

        int wmkCount = getWumenkanQuan(money - mjCount * 10);

        int afterMoney;
        if (money - mjCount * 10 <= wmkCount * 5) {

            afterMoney = 0;
        } else {
            afterMoney = (int) Math.floor((money - mjCount * 10 - wmkCount * 5));
        }

        update(mjCount + wmkCount, afterMoney);
    }
}
