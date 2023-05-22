package com.od.OD.OD100;

import java.util.Scanner;

//�̳��Żݻ

/*
˼·��
����ö���������ͣ������������ �ȴ��ۺ����� �����������ż� �ȴ��ۺ����ż� �����ż������
������������money/100,���������money-10*����
3 2 5
3
100
200
400

* */

public class OD_16_0 {

    public static int manjian;
    public static int dazhe;
    public static int wumenkan;
    //ȯ����Сʹ����
    public static int mincountQuan;
    //���ټ۸�
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
            //�д��۵������
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

    //    �����������
    public static void manjiandazhe(double money) {
        int count = getManjianQuan(money);

        int afterMoney = (int) Math.floor((money - count * 10) * 0.92);

        update(count + 1, afterMoney);
    }

    //    �ȴ��ۺ�����
    public static void dazhemanjian(double money) {
        double v = money * 0.92;
        int count = getManjianQuan(v);

        int afterMoney = (int) Math.floor(v - count * 10);
        update(count + 1, afterMoney);
    }
//    �ȴ��ۺ����ż�

    public static void dazhewumenkan(double money) {
        double v = money * 0.92;
        int count = getWumenkanQuan(v);
        int afterMoney = v <= count * 5 ? 0 : (int) Math.floor(v - count * 5);
        update(count + 1, afterMoney);
    }


    //    �����ż������
    public static void wumenkandazhe(double money) {
        int count = getWumenkanQuan(money);
        if (money <= count * 5) {
            update(0, count);
        } else {
            int afterMoney = (int) Math.floor((money - count * 5) * 0.92);
            update(count + 1, afterMoney);
        }
    }

    //    �����������ż�
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
