package com.od.OD.OD130;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
/*
* 检测热点字符
* */
public class OD_115_new {
    public static int min_num;

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        String input_str = in.next();
        int position = 0;
        int[] chat_count_map = new int[505];

        for(int k=0;k<input_str.length();k++) {
            char t = input_str.charAt(k);
            chat_count_map[t] ++;
            position ++;
            //到M个的时候开始统计
            if(position == M) {
                LinkedList<Integer[]> char_count = new LinkedList<>();
                for(int i = 'a' ; i <= 'z' ; i ++) {
                    char_count.add(new Integer[] {chat_count_map[i], i});
                }
                for(int i = 'A' ; i <= 'Z' ; i ++) {
                    char_count.add(new Integer[] {chat_count_map[i], i});
                }
                for(int i = '0' ; i <= '9' ; i ++) {
                    char_count.add(new Integer[] {chat_count_map[i], i});
                }
                Collections.sort(char_count, new Comparator<Integer []>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        if (o1[0] == o2[0]) {
                            return o1[1].compareTo(o2[1]);
                        } else {
                            return o1[0] - o2[0];
                        }
                    }
                });


                int tmp = N;
                while(char_count.size()>0 && tmp>0) {
                    tmp--;
                    System.out.print((char)(char_count.getLast()[1]-48+'0'));
                    char_count.removeLast();
                }
                position = 0;
            }
        }
        return;
    }
}