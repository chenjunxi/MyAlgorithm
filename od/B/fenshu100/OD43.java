package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
 * 阿里巴巴找黄金箱 III 简单题
6,3,1,6
3
6,3,1,2,6,3,1,6
3

map结构，数字作为key，value存放编号，遇到相同的key，就比较编号之差
 * */
public class OD43 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //箱子上的数字数组。索引表示其编号
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        //咒语数
        int n = sc.nextInt();


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (map.containsKey(num)) {
                Integer integer = map.get(num);

                if (i - integer > n) {
                    map.put(num, i);
                } else {
                    System.out.println(integer + 1);
                    return;
                }
            } else {
                map.put(num, i);
            }

        }
        System.out.println(-1);

    }
}
