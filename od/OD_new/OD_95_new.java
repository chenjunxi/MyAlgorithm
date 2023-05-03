package com.od.OD.OD130;

import java.util.*;
/*
*人数最多的站点
*
* */
class OD_95_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        int max_site = 0;
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            max_site = Math.max(max_site, Math.max(start,end));
            nums[i] = new int[]{start, end};
        }

        ArrayList<Integer[]> sites = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            if (nums[i][0] > nums[i][1]) {
                sites.add( new Integer[]{nums[i][0], max_site});
                sites.add( new Integer[]{1, nums[i][1]});
            } else {
                sites.add( new Integer[]{nums[i][0], nums[i][1]});
            }
        }

        //创建人数的数据结构
        HashMap<Integer, Integer> site_map = new HashMap<>();
        for (Integer[] pair : sites) {
            for (int i = pair[0]; i <= pair[1]; i++) {
                site_map.put(i, site_map.getOrDefault(i, 0) + 1);
            }
        }
        LinkedList<Map.Entry<Integer, Integer>> site_count = new LinkedList<>(site_map.entrySet());

        //先按照人数排序，人数
        site_count.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        site_count.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int res = o2.getValue() - o1.getValue();
                if (res == 0) {
                    res = o1.getKey() - o2.getKey();
                }
                return res;
            }
        });

        System.out.println(site_count.get(0).getKey());
    }


}
