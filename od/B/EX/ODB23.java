package com.od.B.EX;

import java.util.*;
import java.util.stream.Collectors;
/*
* 文件目录大小 dfs
目录id 目录大小 子目录集
3 1     查找目录1，求目录1大小+下面的子目录大小之和
3 15 (0)
1 20 (2)
2 10 (3)

输出 45

思路，两个map，目录id做key，value分别存大小和子目录集

while循环dfs
把要求的目录放在一个栈中，栈初始化就是要查的目录，然后不断往stack添加子目录，不断累加。
当栈大小为空就是循环结束

注意不存在map中的目录，不添加入栈中

* */
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