package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OD51 {
    public static List<Player> win = new ArrayList<>();
    public static List<Player> lose = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        List<Player> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            Player player = new Player(i, Integer.valueOf(strings[i]));
            list.add(player);
        }

        handle(list);

        //赢的争冠亚军
        Collections.sort(win);
        //输的争季军
        Collections.sort(lose);

        System.out.println(win.get(0).id + " " + win.get(1).id + " " + lose.get(0).id);
    }

    public static void handle(List<Player> list) {

        List<Player> resList = new ArrayList<>();
        int len = list.size();
        for (int i = 0; i < len; i += 2) {
            Player one = list.get(i);
            if (i == list.size() - 1) {
                //单独一个直接添加
                resList.add(one);
                if (len == 3) {
                    //单独一个直接赢
                    win.add(one);
                }
                break;
            }
            Player two = list.get(i + 1);
            if (one.power >= two.power) {
                resList.add(one);
                if (len <= 4) {
                    //只有四个需要分输赢了
                    win.add(one);
                    lose.add(two);
                }
            } else {
                resList.add(two);
                if (len <= 4) {
                    //只有四个需要分输赢了
                    win.add(two);
                    lose.add(one);
                }
            }
        }

        if (resList.size() > 4) {
            handle(resList);
        }

    }

    static class Player implements Comparable<Player> {

        int id;
        int power;

        public Player(int id, int power) {
            this.id = id;
            this.power = power;
        }

        @Override
        public int compareTo(Player o) {
            if (this.power == o.power) {
                //实力相等的id小的排在前
                return this.id - o.id;
            }
            return o.power - this.power;
        }
    }
}
