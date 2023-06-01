package com.od.B.fenshu100;

import java.util.*;

public class OD31 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");
        int len = strings.length;
        //发布者集合
        List<Message> pubList = new ArrayList<>();
        for (int i = 0; i < len; i += 2) {
            //发布时间
            int time = Integer.valueOf(strings[i]);
            //消息详情
            Message message = new Message(time, strings[i + 1]);
            pubList.add(message);
        }
        Collections.sort(pubList);

        String[] strings1 = sc.nextLine().split(" ");
        int len1 = strings1.length;
        //消费者集合
        List<int[]> conList = new ArrayList<>();
        for (int i = 0; i < len1; i += 2) {
            //订阅时间
            int a = Integer.valueOf(strings1[i]);
            //取消订阅时间
            int b = Integer.valueOf(strings1[i + 1]);
            int[] ints = new int[]{a, b};
            conList.add(ints);
        }

        Map<Integer, List<String>> map = new HashMap<>();
        for (Message message : pubList) {

            int time = message.time;
            String content = message.content;
            //消费者id
            int index = -1;
            for (int i = 0; i < conList.size(); i++) {
                //消费者订阅和取消订阅时间
                int[] times = conList.get(i);
                if (time > times[0] && time < times[1]) {
                    //订阅时间内的最后一个消费者（优先级最高）
                    index = i;
                }
                if (time == times[0]) {
                    //首次订阅优先获取消息
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                //没有消费者消费信息
                continue;
            }

            if (map.containsKey(index)) {
                map.get(index).add(content);
            } else {
                List<String> list = new ArrayList<>();
                list.add(content);
                map.put(index, list);
            }

        }

        for (int i = 0; i < len1 / 2; i++) {

            if (!map.containsKey(i)) {
                //没有任何消息则输出-1
                System.out.println(-1);
                continue;
            }

            String res = "";
            for (String str : map.get(i)) {
                res += str + " ";
            }
            System.out.println(res.substring(0, res.length() - 1));
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
