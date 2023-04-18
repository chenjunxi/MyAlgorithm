package com.od.OD.OD200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

//满分答案直接背。求出二进制位数，存放在32长度数组中。
public class OD_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[32];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int h = Integer.toBinaryString(x).length();
            nums[h]++;
            ans += (i+1)-nums[h];
        }

        System.out.println(ans);

    }

    private static void dfsDemo(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();

        dfs(list, path, nums, 0);
        System.out.println(list.size());
        System.out.println(list);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> list, ArrayDeque<Integer> path, int[] nums, int i) {
        if (path.size() == 2) {

            Integer a = nums[path.peekLast()];
            Integer b = nums[path.peek()];
            if ((a ^ b) > (a & b)) {
                list.add(new ArrayList<>(path));
            }

            return;
        }

        for (int j = i; j < nums.length; j++) {
            path.add(j);
            dfs(list, path, nums, j + 1);
            path.removeLast();
        }
    }
}
