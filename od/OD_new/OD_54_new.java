package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigInteger;
/*寻找路径
*
* */
class OD_54_new {

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        Integer[] nodes = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        int minValue = Integer.MAX_VALUE;
        int minPos = -1;

        //找最小叶子结点
        for (int i = nodes.length-1; i >= 1; i--) {
            if (nodes[i] != -1) {
                if ((i * 2 + 1 <= nodes.length-1 && nodes[i * 2 + 1] != -1) || (i * 2 + 2 <= nodes.length-1 && nodes[i * 2 + 2] != -1)) {
                    continue;
                }
                if (minValue > nodes[i]) {
                    minValue = nodes[i];
                    minPos = i;
                }
            }
        }

        //往上遍历
        List<Integer> path = new ArrayList<>();
        path.add(minValue);
        while (minPos >= 1) {
            path.add(nodes[(minPos-1)/2]);
            minPos = (minPos-1)/2;
        }

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }

}
