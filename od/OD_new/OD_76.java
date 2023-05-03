package com.od.OD.OD130;

import java.util.*;
/*
* 找数字
* */
//思路使用map记住每个值的全部坐标，然后循环每个值的坐标距离(关键代码)
// 记住本身坐标不要参与距离计算。
public class OD_76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int[][] dp = new int[N][M];

//
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int value = sc.nextInt();

                dp[i][j] = value;

                ArrayList<int[]> list = new ArrayList<>();
                List<int[]> list1 = map.getOrDefault(value, list);
                list1.add(new int[]{i, j});
                map.put(value, list1);
            }
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                temp.add(findintance(dp, map, i, j));
            }
            list.add(temp);
        }

        System.out.println(list);
    }

    private static int findintance(int[][] dp, HashMap<Integer, List<int[]>> map, int i, int j) {
        int key = dp[i][j];
        List<int[]> ints = map.get(key);

        if (ints.size() == 1) return -1;

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < ints.size(); k++) {
            int[] ints1 = ints.get(k);
            if (ints1[0] == i && ints1[1] == j) { //不能统计本身坐标
                continue;
            } else {
                int dd = Math.abs(ints1[0] - i) + Math.abs(ints1[1] - j);
                min = Math.min(min, dd);
            }

        }

        return min;
    }
}
