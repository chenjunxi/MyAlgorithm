package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/*
 *
 * 数组合并
 * */
class OD_34_new {

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();

        //初始化数组
        List<LinkedList<Integer>> num_arrays = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> num_array = Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(LinkedList::new));
            num_arrays.add(num_array);
        }

        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (num_arrays.size() > 0) {
            LinkedList<Integer> single_array = num_arrays.get(index);
            //取出前k个
            for (int i = 0; i < m; i++) {
                //若当前数组已经为空，则跳过
                if (single_array.isEmpty()) {
                    num_arrays.remove(single_array);
                    index--;
                    break;
                }
                builder.append(single_array.removeFirst())
                        .append(",");
            }
            index++;
            if (index >= num_arrays.size()) {
                index = 0;
            }
        }

        System.out.println(builder.substring(0, builder.length() - 1));
    }

}