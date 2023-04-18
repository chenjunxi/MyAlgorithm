package com.od.OD.OD200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OD_45 {
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {

                nums[j] = sc.nextInt();
            }*/

        int[] nums = {3, 4, 5, 3, 4, 5, 5, 6, 12, 13};
        Arrays.sort(nums);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();


        dfs(list, path, nums, 0);
        System.out.println(list);

        //统计有多少组三角形
        Boolean[] used = new Boolean[nums.length];
        Arrays.fill(used, false);
        int count = 0;
        for (List l : list) {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i] && l.contains(nums[i])) {
                    used[i] = true;
                    count++;
                }
            }
        }
        System.out.println(count / 3);
//        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> path, int[] nums, int i) {

        if (path.size() == 3) {
            Integer a = path.get(0);
            Integer b = path.get(1);
            Integer c = path.get(2);
            if (a * a + b * b == c * c) {
                list.add(new ArrayList<>(path));
                return;
            }
        }

        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs(list, path, nums, j + 1);
            path.remove(path.size() - 1);
        }
    }
}
