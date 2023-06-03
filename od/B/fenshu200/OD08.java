package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
A长和宽都大于B
B才可以放在A上面

[[4,6],[3,8],[2,7],[1,4]]

输出3
list存放长和宽的数组
排序降序排序
双循环比较，比较成功之后，要更新参照物
第一个和后面的比较，得出数量count
第二个开始和后面的比较，得出数量max=Math.max(count,count1);
……

 * */


public class OD08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /**
         * 筛选出所有书籍
         */
        String[] str = sc.nextLine().replace("[[", "")
                .replace("]]", "")
                .split("],\\[");

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            String[] shuji = str[i].split(",");
            int length = Integer.parseInt(shuji[0]);  //长
            int width = Integer.parseInt(shuji[1]); //宽
            int[] ints = new int[2];
            ints[0] = length;
            ints[1] = width;
            list.add(ints);
        }

        /**
         * 书籍按照长和宽进行降序排列
         */
        list.sort((a, b) -> {
            if (a[0] < b[0] || (a[0] == b[0] && a[1] < b[1])) {
                return 1;
            }
            return -1;
        });

        //最大规格
        int max = 0;
        for (int i = 0; i < list.size() - max; i++) {
            //第i个参照物
            int lenDown = list.get(i)[0];
            int widDown = list.get(i)[1];
            int count = 1;

            for (int j = i + 1; j < list.size(); j++) {
                int length = list.get(j)[0];
                int width = list.get(j)[1];
                //长和宽同时满足
                if (lenDown > length && widDown > width) {
                    lenDown = length;
                    widDown = width;
                    count++;
                }
            }

            max = Math.max(max, count);
        }


        System.out.println(max);
    }
}
