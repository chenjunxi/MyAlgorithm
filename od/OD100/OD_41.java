package com.od.OD.OD100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OD_41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();

        String[] nums = sc.nextLine().split(" ");
        String[] prices = sc.nextLine().split(" ");

        HashMap<Integer, Integer> times = new HashMap<>();
        HashMap<Integer, Integer> price = new HashMap<>();

        //统计每个序号出现的次数和价格
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.valueOf(nums[i]);
            times.put(num, times.getOrDefault(num, 0) + 1);
            price.put(num, Integer.valueOf(prices[i]));
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> m : times.entrySet()) {

            int key = m.getKey();
            int t = times.get(key);
            int p = price.get(key);

            //两种方案，使用缓存和不适用缓存，哪个便宜用哪个
            sum += t * p > M + p ? M + p : t * p;

        }

        System.out.println(sum);
    }
}
