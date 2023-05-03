package com.od.OD.OD130;

import java.util.*;
/*
*快递投放
* */
class OD_93_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        //包裹信息
        String[][] package_info = new String[m][];
        for (int i = 0; i < m; i++) {
            package_info[i] = in.nextLine().split(" ");
        }
        //检查站信息
        String[][] checkpoint = new String[n][];
        for (int i = 0; i < n; i++) {
            checkpoint[i] = in.nextLine().split(" ");
        }

        HashMap<String, HashSet<String>> package_map = new HashMap<>();
        HashMap<String, HashSet<String>> checkpoint_map = new HashMap<>();

        for (String[] single_package : package_info) {
            //合并起点终点作为key
            package_map.putIfAbsent(single_package[1] + "-" + single_package[2], new HashSet<>());
            package_map.get(single_package[1] + "-" + single_package[2]).add(single_package[0]);
        }

        for (String[] single_checkpoint : checkpoint) {
            checkpoint_map.putIfAbsent(single_checkpoint[0] + "-" + single_checkpoint[1], new HashSet<>());
            checkpoint_map.get(single_checkpoint[0] + "-" + single_checkpoint[1]).addAll(Arrays.asList(Arrays.copyOfRange(single_checkpoint, 2, single_checkpoint.length)));
        }

        ArrayList<String> result = new ArrayList<>();
        for (String key : package_map.keySet()) {
            HashSet<String> packages = package_map.get(key);
            HashSet<String> banned_package = checkpoint_map.get(key);

            if (banned_package == null) {
                continue;
            }

            for (String single_package : packages) {
                if (banned_package.contains(single_package)) {
                    result.add(single_package);
                }
            }
        }

        if (result.size() == 0) {
            System.out.println("none");
        } else {
            //按包裹名排序
            result.sort((a, b) -> Integer.parseInt(a.substring(7)) - Integer.parseInt(b.substring(7)));

            for (int i=0;i<result.size();i++) {
                System.out.println(result.get(i));
                if (i!=result.size()-1) {
                    System.out.println(" ");
                }
            }
        }


    }

}
