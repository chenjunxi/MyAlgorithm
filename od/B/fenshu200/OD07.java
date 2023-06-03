package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
先求全部任意两个区间的公共区间，然后把这些公共区间合并

步骤：
定义区间类，定义好比较器，定义两个list，一个存放公共区间，一个是原始区间
先把区间进行排序，左边升序，右边降序
双循环遍历，两两区间，公共区间求法：取两个区间最大的左，最小的右 ，组成的区间就是公共区间了
再排序好公共区间，然后进行合并，有交集则合并，没交集(l>前区间的右边)，算第二个集合，合并原则：最取最小，右边取最大

0 3
1 3
3 5
3 6
输出：1 5
0 3
1 4
4 7
5 8
输出：
1 3
4 4
5 7

* */
public class OD07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a, b;
        List<Node> nodeList = new ArrayList<>();
        List<Node> nodeList2 = new ArrayList<>();
        while (sc.hasNext()) {
            a = sc.nextInt();
            if (a == -1) {
                break;
            }
            b = sc.nextInt();
            Node node = new Node(a, b);
            nodeList.add(node);
        }
        Collections.sort(nodeList);    //对集合进行排序
        for (int i = 0; i < nodeList.size(); i++) {
            for (int j = i + 1; j < nodeList.size(); j++) {
                if (nodeList.get(j).l <= nodeList.get(i).r) {
                    a = Math.max(nodeList.get(i).l, nodeList.get(j).l);
                    b = Math.min(nodeList.get(i).r, nodeList.get(j).r);
                    nodeList2.add(new Node(a, b));
                }
            }
        }
        if (nodeList2.isEmpty()) {
            System.out.println("None");
            return;
        }
        Collections.sort(nodeList2);
        int l = nodeList2.get(0).l;
        int r = nodeList2.get(0).r;
        for (int i = 1; i < nodeList2.size(); i++) {
            Node node = nodeList2.get(i);
            if (node.l > r) {
                System.out.println(l + " " + r);
                l = node.l;
                r = node.r;
            } else {
                l = Math.min(l, node.l);
                r = Math.max(r, node.r);
            }

        }
        System.out.print(l + " " + r);
    }

    static class Node implements Comparable<Node> {
        private int l;
        private int r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        /**
         * 排序规则
         */
        public int compareTo(Node o) {
            if (this.l == o.l) {
                return this.r - o.r;
            }
            return this.l - o.l;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "l=" + l +
                    ", r=" + r +
                    '}';
        }
    }
}
