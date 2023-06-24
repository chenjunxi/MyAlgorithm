package com.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
/*
全排序
去重两种方法：1 used数组 2 path.contains(nums[i])
* */
public class leecode46_2 {
    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        ArrayDeque<Integer> path = new ArrayDeque<>();

        int[] nums = {1,2,3};
        Boolean[] used = new Boolean[nums.length];
        Arrays.fill(used,false);
        dfs(list, path, nums, used, 0);

        System.out.println(list);

    }

    private static void dfs(ArrayList<ArrayList<Integer>> list, ArrayDeque<Integer> path, int[] nums, Boolean[] used, int index) {

        if (index == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(list, path, nums, used, index + 1);
            path.removeLast();
            used[i] = false;
        }

    }
}
