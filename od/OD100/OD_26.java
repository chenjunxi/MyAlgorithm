package com.od.OD.OD100;

import java.util.HashMap;
import java.util.Scanner;

public class OD_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        String str = strings[0];
        int n = Integer.parseInt(strings[1]);


        HashMap<Integer, StringBuffer> map = new HashMap<>();


        for (int i = 0; i < str.length(); i++) {
            int index;
            if (i / n % 2 == 0) {   //判断是偶数列还是奇数列

                index = i % n;
            } else {
                index = n - 1 - i % n;
            }

            char c = str.charAt(i);
            if (map.containsKey(index)) { //以横坐标作为key，同一行的字符连接一起
                map.get(index).append(c);
            } else {
                map.put(index, new StringBuffer().append(c));
            }
        }

        for (StringBuffer s:map.values()){
            System.out.println(s);
        }

    }
}
