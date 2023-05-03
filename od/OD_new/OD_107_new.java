package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/*
* 统一限载最小值
* */

class OD_107_new {

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Integer[] goods = new Integer[num];
        for (int i=0;i<num;i++) {
            goods[i] = in.nextInt();
        }

        ArrayList<Integer> wet_goods = new ArrayList<Integer>();
        ArrayList<Integer> dry_goods = new ArrayList<Integer>();
        for (int i=0;i<num;i++) {
            if (in.nextInt() == 0)
                dry_goods.add(goods[i]);
            else
                wet_goods.add(goods[i]);
        }
        int k = in.nextInt();

        List<ArrayList<Integer>> datas = new ArrayList<ArrayList<Integer>>();
        datas.add(wet_goods);
        datas.add(dry_goods);

        int result = 0;
        for (ArrayList<Integer> data : datas){
            data.sort(Comparator.naturalOrder());
            int left = data.get(data.size()-1);
            int right = data.stream().reduce (Integer::sum).orElse (0);
            while (left < right) {
                int x = (left + right) / 2;
                int[] cap = new int[k];
                for (int i=0;i<k;i++) {
                    cap[i] = x;
                }
                if (dfs(0, data.size(), k, cap, data,x))
                    right = x;
                else
                    left = x + 1;
            }

            result = Math.max(result, left);
        }

        System.out.println(result);


    }

    public static boolean dfs(int i, int n, int k, int[] cap, ArrayList<Integer> data,int x){
        if (i == n)
            return true;
        for (int j=0;j<k;j++){
            if (cap[j] >= data.get(i)){
                cap[j] -= data.get(i);
                if (dfs(i + 1, n, k, cap, data,x))
                    return true;
                cap[j] += data.get(i);
            }
            if (cap[j] == x)
                break;
        }
        return false;
    }

}