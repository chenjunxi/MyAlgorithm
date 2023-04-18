package com.od.OD.OD200;

import java.util.Scanner;

//公式推出，要么存在-a 或者+a
public class OD_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();
        int count = 1;
        while (true) {

            if ((t - (s - a * count)) % b == 0) {
                break;
            }
            if ((t - (s + a * count)) % b == 0) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
