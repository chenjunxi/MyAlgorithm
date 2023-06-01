package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD03 {
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        fentangguo(n, 0);

        list.sort((a, b) -> {  //从小到大排序
            if (b > a) {
                return -1;
            }
            return 1;
        });

        System.out.println(list.get(0));
    }

    public static int fentangguo(int n, int m) {

        if (n == 1) {
            list.add(m);    //分糖完毕
            return 1;
        }
        if (n % 2 == 0) {
            m++;
            fentangguo(n / 2, m);
        } else {
            m++;
            fentangguo(n - 1, m);
            fentangguo(n + 1, m);
        }
        return 0;
    }
}
