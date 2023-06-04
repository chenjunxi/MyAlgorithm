package com.od.B.EX;

import java.util.*;

/*
* 告警抑制 简单题
*
2
A B
B C
A B C D E
输出ADE
最后一行是告警列表,列表的顺序是无关的，意思就是只有告警列表只要出现抑制关系就成立，对应的低级告警就不会出现
A抑制B，所以B告警不会产生，B抑制C，所以C也不会产生

使用map存放抑制关系
* */
public class ODB14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String[] s = in.nextLine().split(" ");
            String key = s[0];
            String value = s[1];
            if (map.containsKey(key)) {
                ArrayList<String> strings = map.get(key);
                strings.add(value);
                map.put(key, strings);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            }
        }

        String[] alerts = in.nextLine().split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String str : alerts) {

            if (map.containsKey(str)) {
                list.addAll(map.get(str));
            }
        }


        String res = "";
        for (String str : alerts) {

            if (list.contains(str)) {
                continue;
            }
            res += str + " ";
        }

        System.out.println(res.substring(0, res.length() - 1));

    }
}