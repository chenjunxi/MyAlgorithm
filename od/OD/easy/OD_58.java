package com.od.OD.OD130;

import java.util.*;

/*
* 通讯误码
*
5
1 2 2 4 1
输出：2

* */


public class OD_58 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int max_count = 0;
        Map<Integer, Integer> num_count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = num_count.getOrDefault(nums[i], 0) + 1;
            max_count = Math.max(max_count, count);
            num_count.put(nums[i], count);
        }
        Set<Integer> max_num = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : num_count.entrySet()) {
            if (entry.getValue() == max_count) {
                max_num.add(entry.getKey());
            }
        }
        int result = n;
        for (Integer integer : max_num) {

            int left = 0, right = n - 1;
            while (nums[left] != integer) {
                left++;
            }
            while (nums[right] != integer) {
                right--;
            }
            if (left <= right) {
                result = Math.min(result, right - left + 1);
            }
        }

        System.out.println(result);

    }
}