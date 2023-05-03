package com.od.OD.OD130;

import java.util.*;

//整理扑克牌
/*  1 1 1 1 3 3 2 2 2 4 5 6 6 6
    1 3 3 3 2 1 5
    4 4 2 1 2 1 3 3 3 4

 * 思路
 * 1.先用map记录牌的数量。
 * 2、4以上和3放在list43中，2对子放在list2中，单张放在list
 * 3.先遍历list43，4张以上正常输出，3张的时候，判断在连续3张的时候需要拆分
 * 4.拆分逻辑：如果最大的对子值和拆分的3张比较
 * 5.list2和list正常遍历输出即可
 * */
public class OD_46 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");


        //统计数量
        Map<Integer, Integer> map = new HashMap<>();
        for (String string : strings) {
            int i = Integer.valueOf(string);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list43 = new ArrayList<>();
        ArrayList<Map.Entry<Integer, Integer>> list2 = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();


        //根据次数存放对应的list中
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            Integer value = m.getValue();

            if (value >= 3) {
                list43.add(m);
            } else if (value == 2) {
                list2.add(m);
            } else if (value == 1) {
                list.add(m.getKey());
            }
        }

        //自定义排序
        list43.sort((a, b) -> {
            if (a.getValue() != b.getValue()) return b.getValue() - a.getValue();
            return b.getKey() - a.getKey();
        });

        list2.sort((a, b) -> {
            if (a.getValue() != b.getValue()) return b.getValue() - a.getValue();
            return b.getKey() - a.getKey();
        });

        //存放输出
        StringBuilder sb = new StringBuilder();

        //先遍历list43
        for (int i = 0; i < list43.size(); i++) {
            Map.Entry<Integer, Integer> temp = list43.get(i);
            int key = temp.getKey();
            int count = temp.getValue();

            //判断是否是连续3张
            if (i > 0 && list43.get(i - 1) != null && list43.get(i - 1).getValue() == 3 && count == 3) {

                if (list2.size() > 0) { //当有对子的时候
                    if (list43.get(i).getKey() > list2.get(0).getKey()) { //比较对子最大值和当前拆分的3张值
                        list.add(key);
                        count = 2;
                        list43.set(i, null);//拆分之后置为null,防止参与下次比较
                    } else {
                        key = list2.get(0).getKey();
                        count = list2.get(0).getValue();
                        list2.remove(0);
                        i--;  //关键操作，相当于下次遍历再次回到当前遍历
                    }
                } else {  //没有对子的时候自然是要拆分的
                    list.add(key);
                    count = 2;
                    list43.set(i, null); //拆分之后置为null,防止参与下次比较
                }

            }

            for (int j = 0; j < count; j++) {
                sb.append(key + " ");
            }

        }

        if (list2.size() > 0) {
            for (int i = 0; i < list2.size(); i++) {
                Map.Entry<Integer, Integer> temp = list2.get(i);
                int key = temp.getKey();
                int count = temp.getValue();
                for (int j = 0; j < count; j++) {
                    sb.append(key + " ");
                }
            }
        }

        list.sort(Comparator.reverseOrder());

        for (int i:list){
            sb.append(i + " ");
        }

        System.out.println(sb.toString().substring(0, sb.length() - 1));

    }
}
