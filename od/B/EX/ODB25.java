package com.od.B.EX;


import java.util.*;

/*
* 两个整数数组出现的相同数字 简单题
两个数组不存在共同数字，输出NULL
如果有输出格式
次数:num1,num2,num3……
次数2:num3,num4,num5……

出现次数升序，数字也升序。。无语题，花里胡哨的格式
5,8,11,3,6,8,8,-1,11,2,11,11
11,2,11,8,6,8,8,-1,8,15,3,-9,11
输出
1:-1,2,3,6
3:8,11

思路：同时出现，那不就是两个集合的交集？再统计交集中的元素出现的次数
两个数组分别用map统计数字出现的次数
再循环遍历两个map，得到交集的元素和出现次数，然后用第三个map存放，次时map的key为出现的次数，value使用treeSet
再自定义排序……输出
* */
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

        ArrayList<Map.Entry<Integer, TreeSet<Integer>>> entries = new ArrayList<>(same_num_map.entrySet());

        entries.sort((a, b) -> {
            return a.getKey() - b.getKey();
        });

        for (Map.Entry<Integer, TreeSet<Integer>> m : entries) {

            String res = "";
            System.out.print(m.getKey() + ":");
            for (int i : m.getValue()) {
                res += i + ",";
            }
            System.out.println(res.substring(0, res.length() - 1));
        }

    }

}
