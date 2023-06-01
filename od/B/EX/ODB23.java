package com.od.B.EX;

import java.util.*;
import java.util.stream.Collectors;

public class ODB23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        HashMap<Integer, ArrayList<Integer>> dir_map = new HashMap<>();
        HashMap<Integer, Integer> dir_info = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int id = in.nextInt();
            int size = in.nextInt();

            dir_map.putIfAbsent(id, new ArrayList<>());
            dir_info.putIfAbsent(id, size);

            String childs = in.next();
            if (childs.length() > 2) {
                dir_map.get(id).addAll(Arrays.stream(childs.substring(1, childs.length() - 1).split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
            }
        }

        System.out.println(dfs(dir_map, dir_info, n));
        return;
    }

    public static int dfs(
            HashMap<Integer, ArrayList<Integer>> dir_map, HashMap<Integer, Integer> dir_info, int target) {
        int ans = 0;

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(target);

        while (stack.size() > 0) {
            Integer id = stack.pop();
            if (!dir_info.containsKey(id)) continue;
            ans += dir_info.get(id);
            stack.addAll(dir_map.get(id));
        }

        return ans;
    }
}