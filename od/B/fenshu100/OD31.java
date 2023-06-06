package com.od.B.fenshu100;

import java.util.*;

/*
 *模拟消息队列
2 22 1 11 4 44 5 55 3 33
1 7 2 3


思路：把发布转成状态数组dp，
遍历订阅者list，存放treemap中，数据结构题
 * */
public class OD31 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] fabu = sc.nextLine().split(" ");
        String[] dingyue = sc.nextLine().split(" ");


        int max = 0;
        int[] fabunums = Arrays.stream(fabu).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < fabunums.length; i++) {

            max = Math.max(max, fabunums[i]);
        }

        int[] dp = new int[max + 1];
        for (int i = 0; i < fabunums.length; i += 2) {
            dp[fabunums[i]] = fabunums[i + 1];
        }

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < dingyue.length; i += 2) {
            list.add(new int[]{Integer.valueOf(dingyue[i]), Integer.valueOf(dingyue[i + 1])});
        }


        TreeMap<Integer, ArrayList<int[]>> map = new TreeMap<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            int[] ints = list.get(i);
            int start = ints[0];
            int end = ints[1];

            ArrayList<int[]> temp = new ArrayList<>();
            for (int j = start; j < end; j++) {

                int i1 = dp[j];
                if (i1 == 0) continue;


                temp.add(new int[]{j, i1});
                dp[j] = 0;
            }
            temp.sort((a, b) -> a[0] - b[0]);

            map.put(i, temp);

        }

        //输出即可
        Set<Map.Entry<Integer, ArrayList<int[]>>> entries = map.entrySet();
        for (Map.Entry<Integer, ArrayList<int[]>> m : map.entrySet()) {
            ArrayList<int[]> value = m.getValue();
            for (int[] a : value) {
                System.out.print(a[1] + " ");
            }
            System.out.println();
        }


    }

    static class Message implements Comparable<Message> {

        int time;
        String content;

        public Message(int time, String content) {

            this.time = time;
            this.content = content;

        }

        @Override
        public int compareTo(Message o) {
            return this.time - o.time;
        }
    }
}
