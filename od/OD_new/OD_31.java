package com.od.OD.OD130;

import java.util.PriorityQueue;
import java.util.Scanner;


//利用优先级队列，每次对最小值进行加1
public class OD_31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> queu = new PriorityQueue<>((x, y) -> x - y);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            queu.add(sc.nextInt());
        }

        sc.close();

        for (int i = 0; i < m; i++) {
            int newValue = queu.poll() + 1;
            queu.add(newValue);
        }

        while (!queu.isEmpty()) {
            System.out.print(queu.poll());
        }

    }
}
