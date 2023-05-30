package com.od.OD.bei;

import java.util.Arrays;
import java.util.Scanner;

/*最少线段覆盖
 * 3中情况验证
 *   1,3 4,5 6,7
 *   1,4 2,5 3,6
 *   1,4 3,6 5,8
 *
 * */
public class OD_22 {
    public static void main(String[] args) {

        Node[] arr = new Node[10000];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String[] s = sc.next().split(",");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            arr[i] = new Node(v1, v2);
        }

        Arrays.sort(arr, 0, n - 1);
        if (n == 0) {
            System.out.println(0);
        } else {
            int res = 1;
            //覆盖线段分界点（左侧已经被覆盖）
            int right = arr[0].r;
            //最大的右侧节点
            int maxRight = arr[0].r;
            for (int i = 1; i < n; i++) {
                if (arr[i].l > right) {
                    //说明right左侧的线段与线段arr[i]没有交集（无法进行覆盖了）
                    if (maxRight > right) {
                        //说明right到maxRight之间有线段之前没有覆盖，现在需要新的线段覆盖
                        res++;
                        //更新分界点为maxRight
                        right = maxRight;
                    }
                    if (maxRight < arr[i].l) {
                        //说明arr[i]跟前面所有的线段都没有交集，重新开始计算了
                        res++;
                        //分界点也要变成arr[i]的右节点（相当于初始化了）
                        right = arr[i].r;
                    }
                }
                //线段最右节点需要更新
                maxRight = Math.max(arr[i].r, maxRight);
            }
            if (maxRight > right) {
                //说明right到maxRight之间有线段还没有覆盖，需要再加一条
                res++;
            }
            System.out.println(res);
        }
    }

    static class Node implements Comparable<Node> {
        int l, r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Node o) {
            if (l == o.l) {
                return o.r - r;
            }
            return l - o.l;
        }
    }
}
