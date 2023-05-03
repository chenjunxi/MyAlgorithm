package com.od.OD.OD130;

import java.util.*;
import java.util.stream.Collectors;
/*查找二叉树节点
*
* */
class OD_69_new {
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        ArrayList<Integer[]> nodes_info = new ArrayList<>();
        for(int i=0; i<n; i++) {
            nodes_info.add(Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new));
        }

        int x = in.nextInt();
        int y = in.nextInt();

        System.out.print(get_result(nodes_info, x, y));
    }

    private static String get_result(ArrayList<Integer[]> nodes, int x, int y) {
        if (x < 0 || y < 0) {
            return "{}";
        }

        List<Integer> list = new ArrayList<>();
        calc(nodes, 0, x, list);

        if (y >= list.size()) {
            return "{}";
        }

        return "{" + list.get(y) + "}";
    }

    private static void calc(ArrayList<Integer[]> nodes, int index, int n, List<Integer> list) {
        Integer[] node = nodes.get(index);
        if (n == 0) {
            list.add(node[0]);
            return;
        }


        if (node.length == 1) {
            return;
        }

        for (Integer i = 1; i < node.length; i++) {
            calc(nodes, node[i], n - 1, list);
        }
    }
}