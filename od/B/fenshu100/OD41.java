package com.od.B.fenshu100;

import java.util.*;
/*
* 网站统计

思路：map记录次数，然后对map进行排序
* */
public class OD41 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        while (sc.hasNext()) {

            String str = sc.nextLine();
            if (!str.contains(".")) { //不包含.的就是数字
                int n = Integer.parseInt(str);
                if (n > map.size()) {   //如果数字大于网站个数这退出
                    break;
                }

                List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet()); //将map转换成list
                String res = "";
                list.sort((a, b) -> {  //对list进行降序排序
                    if (b.getValue() < a.getValue()) {
                        return -1;
                    }
                    return 1;
                });

                for (int i = 0; i < n; i++) {
                    res += list.get(i).getKey();
                    if (i != n - 1) {
                        res += ",";
                    }
                }

                System.out.println(res);
            } else {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
    }
}
