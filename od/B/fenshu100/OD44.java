package com.od.B.fenshu100;

import java.util.*;

/*
 * 阿里巴巴找黄金箱 IV

1,1,1,1,3,3,3,6,6,8
输出2

又是map题，记录数字的出现的次数，然后按次数降序，优先销毁出现次数最多的。当累加销毁的数量达到要求就break
 * */
public class OD44 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(",");
        /**
         * key：数字
         * value：数字的个数
         */
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        //按照数字个数降序排序
        list.sort((a, b) -> {
            return b.getValue() - a.getValue();
        });
        //销毁的箱子个数
        int count = 0;
        //半数箱子（因为是半数及以上，所以需要向上取整）
        int half = (int) Math.ceil((double) strings.length / 2);
        //数组的长度
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getValue();
            res++;
            if (count >= half) {
                //已经销毁半数及以上
                break;
            }
        }

        System.out.println(res);
    }
}
