package com.od.B.fenshu100;

import java.util.*;

public class OD30 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings1 = sc.nextLine().split(",");
        int M = Integer.valueOf(strings1[0]);
        int N = Integer.valueOf(strings1[1]);

        if (M < 3 || M > 10 || N < 3 || N > 100) {
            System.out.println(-1);
        } else {
            //选手成绩集合
            List<Player> list = new ArrayList<>();
            for (int i = 0; i < M; i++) {

                String[] strings = sc.nextLine().split(",");
                //评委打分数组
                int[] scores = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

                for (int j = 0; j < N; j++) {
                    int score = scores[j];
                    if (score < 1 || score > 10) {
                        //分数不符合跳出
                        System.exit(-1);
                    }
                    if (list.size() <= j) {
                        //集合为空，则新建
                        int[] ints = new int[10];
                        ints[10 - score]++;
                        Player player = new Player(j + 1, score, ints);
                        list.add(player);
                    } else {
                        list.get(j).score += score;
                        list.get(j).ints[10 - score]++;
                    }
                }
            }

            Collections.sort(list);

            String res = "";
            for (int i = 0; i < 3; i++) {
                res += list.get(i).no + ",";
            }

            System.out.println(res.substring(0, res.length() - 1));
        }

    }

    static class Player implements Comparable<Player> {

        int no;
        int score;
        int[] ints;

        public Player(int no, int score, int[] ints) {
            this.no = no;
            this.score = score;
            this.ints = ints;
        }

        @Override
        public int compareTo(Player o) {
            if (this.score == o.score) {
                for (int i = 0; i < 10; i++) {
                    if (this.ints[i] == o.ints[i]) {
                        continue;
                    }
                    return o.ints[i] - this.ints[i];
                }
            }
            return o.score - this.score;
        }
    }
}
