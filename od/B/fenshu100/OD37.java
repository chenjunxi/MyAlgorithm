package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
* 数组合并
3  取长度
2  2行数组
2,5,6,7,9,5,7
1,7,4,3,4
3
2
2,5,6,7,9,5,7
1,7,4,3,4

输出：2,5,6,1,7,4,7,9,5,3,4,7

while循环数组，index索引，index+=step；
* */
public class OD37 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int step = sc.nextInt();
        int m = sc.nextInt();
        List<List<String>> lists = new ArrayList<>();
        sc.nextLine();

        int count = 0;
        for (int i = 0; i < m; i++) {
            String[] strings = sc.nextLine().split(",");
            count += strings.length;
            List<String> collect = Arrays.stream(strings).collect(Collectors.toList());
            lists.add(collect);  //将数组放入集合中
        }

        List<Integer> res = new ArrayList<>();


        int index = 0;
        while (res.size() != count) {
            for (int i = 0; i < lists.size(); i++) {
                List<String> strings = lists.get(i);
                if (index > strings.size()) continue;

                int end = Math.min(step, strings.size() - index) + index;
                for (int j = index; j < end; j++) {
                    res.add(Integer.valueOf(strings.get(j)));
                }

            }
            index += step;
        }

        System.out.println(res);

    }

    private static void demo(int step, int m, List<List<String>> lists, List<Integer> res) {
        int n = 0;  //起始下标
        int count = 0;  //取完数字的数组
        while (count < m) {    //当取完的数组数量小于m时进入循环
            for (int i = 0; i < m; i++) {
                List<String> list = lists.get(i);
                if (n > list.size()) {  //当其实下标大于数组长度时退出本次循环
                    continue;
                }
                int end = n + step; //结束位置下标
                if (end >= list.size()) {   //当结束位置下标大于等于数组长度时
                    end = list.size();
                    count++;    //取完数字数组数量+1
                }
                for (int j = n; j < end; j++) {
                    res.add(Integer.parseInt(list.get(j)));
                }
            }
            n += step;    //起始位置下标变更（+step）
        }

        System.out.println(res);
    }
}
