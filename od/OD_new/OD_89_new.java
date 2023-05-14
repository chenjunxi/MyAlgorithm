package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/*
 * 修建高铁最优成本 并查集不懂
3 3 0
1 2 10
1 3 100
2 3 50
输出
60
解释：
3 3 0城市圈数量为3，表示城市id分别为1,2,3；3表可建数量 0表示必建高铁的城市数
1 2 10城市1，2间的高铁修建成本为10
1 3 100城市1，3间的高铁修建成本为100
2 3 50城市2，3间的高铁修建成本为50
满足修建成本最低，只需要建设城市1，2间，城市2，3间的高铁即可，
城市1，3之间可通过城市2中转来互联。这样最低修建成本就是60。

3 3 1
1 2 10
1 3 100
2 3 50
1 3 必建高铁
输出110
 * */
class OD_89_new {
    // 并查集
    static class UF {
        int[] item;
        int count;

        public UF(int n) {
            item = new int[n + 1];
            count = n;
            for (int i = 0; i < n; i++) item[i] = i;
        }

        public int find(int x) {
            if (x != item[x]) {
                return (item[x] = find(item[x]));
            }
            return x;
        }

        public void union(int x, int y) {
            int x_item = find(x);
            int y_item = find(y);

            if (x_item != y_item) {
                item[y_item] = x_item;
                count--;
            }
        }
    }

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int pair_count_1 = in.nextInt();
        int pair_count_2 = in.nextInt();

        // 可建设高铁的两城市
        int[][] city_pair_1 = new int[pair_count_1][3];
        for (int i = 0; i < pair_count_1; i++) {
            city_pair_1[i][0] = in.nextInt();
            city_pair_1[i][1] = in.nextInt();
            city_pair_1[i][2] = in.nextInt();
        }

        // 必建高铁的两城市
        int[][] city_pair_2 = new int[pair_count_2][2];
        for (int i = 0; i < pair_count_2; i++) {
            city_pair_2[i][0] = in.nextInt();
            city_pair_2[i][1] = in.nextInt();
        }

        UF uf = new UF(n);

        // key为修建高铁的两个城市，value为费用
        HashMap<String, Integer> city_map = new HashMap<>();
        for (int[] city_pair : city_pair_1) {
            int city1 = city_pair[0], city2 = city_pair[1];
            city_map.put(city1 < city2 ? city1 + "-" + city2 : city2 + "-" + city1, city_pair[2]);
        }

        int result = 0;
        // 先计算必建高铁情况下的费用
        for (int[] city_pair : city_pair_2) {
            int city1 = city_pair[0], city2 = city_pair[1];
            result += city_map.get(city1 < city2 ? city1 + "-" + city2 : city2 + "-" + city1);
            // 纳入并查集
            uf.union(city1, city2);
        }
        System.out.println(result);

        //  已经满足所有城市通车，直接返回
        if (uf.count == 1) {
            System.out.println(result);
            return;
        }

        // 按修建费用排序
        Arrays.sort(city_pair_1, (a, b) -> a[2] - b[2]);

        for (int[] city_pair : city_pair_1) {
            int city1 = city_pair[0], city2 = city_pair[1];
            // 判断两城市是否相连
            if (uf.item[city1] != uf.item[city2]) {
                uf.union(city1, city2);
                // 若可以合入，则将对应的建造成本计入result
                result += city_pair[2];
            }
            if (uf.count == 1) {
                break;
            }
        }

        // count>1代表有的城市无法通车
        if (uf.count > 1) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);
    }

}
