package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OD25 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] str1 = sc.nextLine().split("-");
        String[] str2 = sc.nextLine().split("-");
        int len1 = str1.length;
        int len2 = str2.length;

        HashMap<String, Integer> map = new HashMap<>();  //当前手中的牌和出过的牌的键值对

        for (int i = 0; i < len1; i++) {
            map.put(str1[i], map.getOrDefault(str1[i], 0) + 1);
        }

        for (int i = 0; i < len2; i++) {
            map.put(str2[i], map.getOrDefault(str2[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(); //对手的牌（除去2）
        List<Integer> listFour = new ArrayList<>(); //已经出了4张的牌
        for (int i = 3; i <= 14; i++) {
            list.add(i);
        }

        map.forEach((k, v) -> {
            if (v == 4) {
                int n;
                switch (k) {
                    case "J":
                        n = 11;
                        break;
                    case "Q":
                        n = 12;
                        break;
                    case "K":
                        n = 13;
                        break;
                    case "A":
                        n = 14;
                        break;
                    default:
                        n = Integer.valueOf(k);
                }
                listFour.add(n);
            }
        });

        for (int i = 0; i < listFour.size(); i++) { //剔除已经出过四张的牌
            for (int j = 0; j < list.size(); j++) {
                if (listFour.get(i) == list.get(j)) {
                    list.remove(j);
                }
            }
        }

        List<Integer> res = new ArrayList<>();  //最长顺子
        List<Integer> temp = new ArrayList<>(); //顺子容器，用来判断是否是顺子，是否是最长的顺子
        int count = 1;  //连续牌的个数
        int max = 0;    //最长顺子长度
        temp.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 1) {
                temp.add(list.get(i));
                count++;
                if (i == list.size() - 1 && count >= 5 && count == Math.max(max, count)) { //最后一张牌也需要进行判断
                    res = temp;
                }
            } else {
                if (count >= 5 && count == Math.max(max, count)) {
                    res = temp;
                }
                temp.clear();   //容器置空
                temp.add(list.get(i));
                count = 1;
            }
        }

        if (res.size() == 0) {
            System.out.println("NO-CHAIN");
        } else {
            String s = "";
            for (int i = 0; i < res.size(); i++) {
                int n = res.get(i);
                switch (n) {
                    case 11:
                        s += "J";
                        break;
                    case 12:
                        s += "Q";
                        break;
                    case 13:
                        s += "K";
                        break;
                    case 14:
                        s += "A";
                        break;
                    default:
                        s += String.valueOf(n);
                }
                if (i != res.size() - 1) {
                    s += "-";
                }
            }
            System.out.println(s);
        }
    }
}
