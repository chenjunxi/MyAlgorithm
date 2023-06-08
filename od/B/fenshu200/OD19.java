package com.od.B.fenshu200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
* 跳房子
求给出数组中，按顺序的找出3个数之和等于给出的值
[1,4,5,2,0,2]
9
输出 [4,5,0]

如果有多个输出索引和最小的

思路：经典dfs回溯法
* */
public class OD19 {
    static public int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("\\[", "").replaceAll("\\]", "");
        String[] split = s.split(",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        int k = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();

        dfs(list, path, ints, 0, 0, k);

        ArrayList<Integer> list1 = list.get(0);
        for (int i : list1) {
            System.out.print(ints[i] +" ");
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> list, ArrayDeque<Integer> path, int[] ints, int index, int sum, int k) {

        if (path.size() > 3) return;
        if (path.size() == 3 && sum == k) {
            int count = 0;
            for (int i : path) {
                count += i;
            }

            if (count < min) {
                min = count;
                list.clear();
                list.add(new ArrayList<>(path));
            }

            return;
        }

        for (int i = index; i < ints.length; i++) {

            int anInt = ints[i];

            if (sum + anInt <= k) {
                path.add(i);
                sum += anInt;
                dfs(list, path, ints, i + 1, sum, k);
                sum -= anInt;
                path.removeLast();
            }

        }
    }
}
