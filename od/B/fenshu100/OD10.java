package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OD10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.valueOf(str[i]);
            int l = i * 100 - x > 0 ? i * 100 - x : 0;    //边界处理
            int r = i * 100 + x > (n - 1) * 100 ? (n - 1) * 100 : i * 100 + x;
            Node node = new Node(l, r);
            list.add(node);
        }

        Collections.sort(list);
        int left = list.get(0).left;
        int right = list.get(0).right;
        List<Node> list1 = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.left > right) {
                Node node1 = new Node(left, right);
                list1.add(node1);
                left = node.left;
                right = node.right;
            } else {
                left = Math.min(left, node.left);
                right = Math.max(right, node.right);
            }
        }

        list1.add(new Node(left, right));
        int res = 0;
        for (int i = 1; i < list1.size(); i++) {
            res += (list1.get(i).left - list1.get(i - 1).right);
        }

        System.out.println(res);
    }

    static class Node implements Comparable<Node> {

        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if (this.left == o.left) {
                return this.right - o.right;
            }
            return this.left - o.left;
        }
    }
}
