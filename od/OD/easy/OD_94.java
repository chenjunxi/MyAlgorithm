package com.od.OD.OD130;


import java.util.*;
/*
* 优秀学员统计
* */
//使用自定义优先队列进行排序，使用map统计ID对应的打卡天数和首次打卡天
public class OD_94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        sc.nextLine();//第二行输入无视

        //定义map,id做key，数组记录打卡首次打卡天和打卡总数
        Map<Integer, int[]> map = new HashMap<>();

        //定义优先队列
        PriorityQueue<Map.Entry<Integer, int[]>> queue = new PriorityQueue<>((a, b) -> {
            int[] valueA = a.getValue();
            int[] valueB = b.getValue();

            if (valueA[1] != valueB[1]) return valueB[1] - valueA[1]; //打卡数优先比较，降序

            if (valueA[0] != valueB[0]) return valueA[0] - valueB[0]; //首次打卡天比较，升序

            return a.getKey() - b.getKey(); //最后工号排序，升序
        });

        for (int i = 1; i <= 30; i++) {
            String[] input = sc.nextLine().split(" ");

            for (String s : input) {
                int id = Integer.parseInt(s);

                if (map.containsKey(id)) {
                    int[] ints = map.get(id);
                    ints[1]++;
                    map.put(id, ints);
                } else {
                    map.put(id, new int[]{i, 1});
                }

            }
        }

        //添加到优先队列
        for (Map.Entry<Integer, int[]> m : map.entrySet()) {
            queue.offer(m);
        }

        //输出
        for (int i = 0; i < 5; i++) {
            Map.Entry<Integer, int[]> poll = queue.poll();
            System.out.print(poll.getKey() + " ");
            if (queue.isEmpty()) break;
        }
    }
}
