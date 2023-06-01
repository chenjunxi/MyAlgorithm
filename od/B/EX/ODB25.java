package com.od.B.EX;


import java.util.*;

public class ODB25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums1 = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> num1_map = new HashMap<>();
        for (int num : nums1) {
            num1_map.put(num, num1_map.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> num2_map = new HashMap<>();
        for (int num : nums2) {
            num2_map.put(num, num2_map.getOrDefault(num, 0) + 1);
        }
        boolean flag = true;

        HashMap<Integer, TreeSet<Integer>> same_num_map = new HashMap<>();
        for (Integer num : num1_map.keySet()) {
            if (num2_map.containsKey(num)) {
                flag = false;
                int count = Math.min(num1_map.get(num), num2_map.get(num));
                same_num_map.putIfAbsent(count, new TreeSet<>());
                same_num_map.get(count).add(num);
            }
        }
        if (flag) {
            System.out.println("NULL");
            return;
        }

        same_num_map.keySet().stream().sorted().forEach(
                count -> {
                    StringJoiner sj = new StringJoiner(",", count + ":", "");
                    for (Integer num : same_num_map.get(count)) {
                        sj.add(num + "");
                    }
                    System.out.println(sj.toString());
                });
        return;
    }

}
