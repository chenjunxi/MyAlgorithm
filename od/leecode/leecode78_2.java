package com.leecode;

import java.util.*;

//子集问题
public class leecode78_2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            dfs(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
