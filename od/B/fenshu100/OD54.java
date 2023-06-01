package com.od.B.fenshu100;

import java.util.*;

public class OD54 {
    public static int res = 0;
    public static int target;
    public static List<List<Integer>> numsList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int k = sc.nextInt();
        target = sc.nextInt();

        combine(nums, k, new ArrayList<>(), 0);

        System.out.println(res);
    }

    /**
     * M中选其N个数
     *
     * @param nums  数组
     * @param n     n个数
     * @param list  选取的数字
     * @param index 数组的索引
     */
    public static void combine(int[] nums, int n, List<Integer> list, int index) {

        if (n == 0) {
            int count = 0;
            for (Integer i : list) {
                count += i;
            }
            if (count == target && !isContain(list)) {
                //是否满足target的同时还需满足元素不重复的情况
                numsList.add(new ArrayList<>(list));
                res++;
            }
        } else {
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                combine(nums, n - 1, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 是否包含集合
     *
     * @param list
     * @return
     */
    public static boolean isContain(List<Integer> list) {

        Collections.sort(list);
        for (List<Integer> l : numsList) {
            Collections.sort(l);
            if (l.toString().equals(list.toString())) {
                return true;
            }
        }

        return false;
    }
}
