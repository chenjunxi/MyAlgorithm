package com.od.OD.bei;

import java.util.*;
/*
 * 统一限载最小值
 *
 *
 *
 * */

class OD_107 {

    public static int k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        int[] goods = new int[len];
        for (int i = 0; i < len; i++) {
            goods[i] = sc.nextInt();
        }

        int[] types = new int[len];
        for (int i = 0; i < len; i++) {
            types[i] = sc.nextInt();
        }

        k = sc.nextInt();

        List<Integer> listDry = new ArrayList<>();      //干货物
        List<Integer> listWet = new ArrayList<>();      //湿货物
        int countDry = 0;       //干货物总重
        int countWet = 0;       //湿货物总重
        for (int i = 0; i < len; i++) {
            int type = types[i];
            int good = goods[i];
            if (type == 0) {
                listDry.add(good);
                countDry += good;
            } else {
                listWet.add(good);
                countWet += good;
            }
        }

        Collections.sort(listDry);
        Collections.sort(listWet);

        int minDry = 0;
        int minWet = 0;
        if (listDry.size() != 0) {
            minDry = handle(listDry, countDry);
        }
        if (listWet.size() != 0) {
            minWet = handle(listWet, countWet);
        }
        int res = Math.max(minDry, minWet);

        System.out.println(res);

    }

    /**
     * 求出最小货物限载量
     *
     * @param goodList 货物集合
     * @param count    货物总重
     * @return
     */
    public static int handle(List<Integer> goodList, int count) {

        //最重货物
        int maxList = goodList.get(goodList.size() - 1);
        //平均每辆车放置的最低重量
        int minWeight = count % k == 0 ? count / k : count / k + 1;
        //最少限载货物量
        int min = Math.max(maxList, minWeight);
        //最大限载货物量（一辆车的时候）
        int max = count;

        //二分法
        while (min < max) {

            int mid = (min + max) / 2;
            //K辆车（每次都需要初始化）
            int[] vans = new int[k];
            if (check(goodList, 0, vans, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    /**
     * 判断当前限载货物量是否能装完货物
     *
     * @param goods  货物集合
     * @param index  货物索引
     * @param vans   货车数组
     * @param weight 限载货物量
     * @return
     */
    public static boolean check(List<Integer> goods, int index, int[] vans, int weight) {
        /*
         * index == nums.length说明都放完了
         */
        if (index == goods.size()) {
            return true;
        }
        for (int i = 0; i < vans.length; i++) {
            //多辆车货物重量一样,前面已经试了不要重复试,此处可能不好理解
            if (i > 0 && vans[i] == vans[i - 1]) {
                continue;
            }
            // 满足条件才能放入
            if (vans[i] + goods.get(index) <= weight) {
                // 放入
                vans[i] = vans[i] + goods.get(index);
                // 后续递归放入剩余的货物
                if (check(goods, index + 1, vans, weight)) {
                    return true;
                }
                //上面的策略失败了,就回退,继续尝试后面的策略
                vans[i] = vans[i] - goods.get(index);
            }
        }
        return false;
    }
}