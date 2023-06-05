package com.od.B.fenshu100;

import java.util.*;
/*
*统计射击
*map结构
* */
public class OD21 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] s1 = sc.nextLine().split(","); //队员
        String[] s2 = sc.nextLine().split(","); //射击成绩

        Map<Integer, List<Integer>> map = new HashMap<>();

        /**
         * 队员作为key值，成绩作为value值（集合）
         */
        for (int i = 0; i < n; i++) {
            int key = Integer.valueOf(s1[i]);
            int value = Integer.valueOf(s2[i]);
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            }
        }
        /**
         * 将队员id及最高三个成绩之和放入集合list
         * 将所有队员数据放在集合lists
         */
        List<List<Integer>> lists = new ArrayList<>();
        map.forEach((a, b) -> {
            List<Integer> list = new ArrayList<>();
            if (b.size() >= 3) {    //成绩大于等于3才有效
                Collections.sort(b);    //升序排序（从小到大）
                list.add(a);    //a为队员id
                //取倒数三个成绩之和为总成绩
                list.add(b.get(b.size() - 1) + b.get(b.size() - 2) + b.get(b.size() - 3));
            }
            lists.add(list);
        });

        lists.sort((a, b) -> {
            if (b.get(1) > a.get(1)) {  //成绩高的在前
                return 1;
            }
            if (b.get(0) > a.get(0)) {  //成绩相等时，id高的在前
                return 1;
            }
            return -1;
        });

        String res = "";
        for (int i = 0; i < lists.size() - 1; i++) {
            res += lists.get(i).get(0) + ",";   //各队员成绩的第一个数为其id
        }
        System.out.println(res + lists.get(lists.size() - 1).get(0));
    }
}
