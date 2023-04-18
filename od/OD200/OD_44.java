package com.od.OD.OD200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/*
* 要求就是 ：求出干车和湿车的最大限制重量
*
* 1.首先2个list分别存放干湿的货物，并排序
* 2.通过二分查找，适合的限制重量
* 3.check函数类似回溯的递归
*
* */
public class OD_44 {
    public static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] goods = new int[len];
        for (int i = 0; i < len; i++) {
            goods[i] = sc.nextInt();
        }

        int[] type = new int[len];
        for (int i = 0; i < len; i++) {
            type[i] = sc.nextInt();
        }

        k = sc.nextInt();

        ArrayList<Integer> listDry = new ArrayList<>();
        ArrayList<Integer> listWet = new ArrayList<>();
        int contDry = 0;
        int countWet = 0;

        for (int i = 0; i < len; i++) {
            if (type[i] == 0) {
                contDry += goods[i];
                listDry.add(goods[i]);
            }

            if (type[i] == 1) {
                countWet += goods[i];
                listWet.add(goods[i]);
            }
        }

        Collections.sort(listDry);
        Collections.sort(listWet);

        int minDry = 0;
        int minWet = 0;
        if (listDry.size() != 0) {
            minDry = handle(listDry, contDry);
        }

        if (listWet.size() != 0) {
            minDry = handle(listWet, countWet);
        }

        System.out.println(Math.max(minDry, minWet));
    }

    private static int handle(ArrayList<Integer> goodList, int cont) {

        //利用二分查找思想，从平均值或者最大货物值到 总的货物值，判断哪个限制值合适。
        int maxList = goodList.get(goodList.size() - 1);
        int minWeight = cont % 2 == 0 ? cont / k : cont / k + 1;


        int min = Math.min(maxList, minWeight);
        int max = cont;

        while (min < max) {
            int mid = (min + max) / 2;
            int[] vans = new int[k];

            if (check(goodList, 0, vans, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        return min;
    }

    private static boolean check(ArrayList<Integer> goodList, int index, int[] vans, int weightLimit) {

        if (index == goodList.size()) {
            return true;
        }

        for (int i = 0; i < vans.length; i++) {

            if (i > 0 && vans[i] == vans[i - 1]) {
                continue;
            }

            if (vans[i] + goodList.get(index) <= weightLimit) {
                vans[i] = vans[i] + goodList.get(index);
                if (check(goodList, index + 1, vans, weightLimit)) {
                    return true;
                }
                vans[i] = vans[i] - goodList.get(index);
            }
        }

        return false;
    }
}
