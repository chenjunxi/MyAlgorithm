package com.od.OD.OD130;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//完美走位思路就是
// 1.长度/4=平均值
// 2.统计每个字符超出平均值多少个
// 3.把超出部分取出来
// 4.for循环，遇到超额的字符就减一，直到减完总数
// 5.获取每次最小的步数
public class OD_12 {
    public static void main(String[] args) {
        String str = "aaawdwassddd";
//        String str = "ASWDASWDAAAA";

        int length = str.length();
        int perfext = length / 4; // 1.长度/4=平均值
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> mapSub = new HashMap<>();

//        2.统计每个字符超出平均值多少个
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1 - perfext);
            }
        }

        // 3.把超标部分取出来
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 0) {
                mapSub.put(key, value);
                count += value;
            }
        }

        int min = length - 1;

        //mapSub大小为0说明没有超标，输出0即可
        if (mapSub.size() > 0) {
            // 4.for循环，遇到超额的字符就减一，直到减完总数
            for (int i = 0; i < length; i++) {
                HashMap<Character, Integer> copyMap = new HashMap<>(mapSub);
                int right = i;
                int temp = count;
                boolean flag = false;
                char c = str.charAt(i);
                if (copyMap.containsKey(c)) {
                    while (right < length) {
                        char c1 = str.charAt(right);
                        if (copyMap.containsKey(c1) && copyMap.get(c1) > 0) {
                            copyMap.put(c1, copyMap.get(c1) - 1);
                            temp--;
                        }
                        right++; //连续作用
                        if (temp == 0) { //减完说明已经达到要求了
                            flag = true;
                            break;
                        }
                    }
                } else {
                    continue;
                }

                if (flag) {  //每次以i为起点的操作都达到要求了，才比较最小值。
                    System.out.println("第" + i + "次：" + (right - i));
                    min = Math.min(min, right - i);
                }
            }
            System.out.println(min);
        } else {
            System.out.println("0");
        }
    }

}
