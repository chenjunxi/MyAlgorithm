package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 分糖果 这道题重点在数字范围  思路：递归方法
求至少多少次，能将手中的糖果分至成一颗
15
输出5
15+1=16
16/2=8
8/2=4
4/2=2
2/2=1
9900000000
41


 * */
public class OD03 {
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        int allocate = allocate(n);
        System.out.println(allocate);

    }

    private static int allocate(long num) {
        if (num == 2) {
            return 1;
        }
        if (num % 2 == 0) {
            return allocate(num / 2) + 1;
        } else if (num == 3 || num % 4 == 1) { //减一优先执行，因为减一会更少操作
            return allocate(num - 1) + 1;
        } else {
            return allocate(num + 1) + 1;
        }
    }

}
