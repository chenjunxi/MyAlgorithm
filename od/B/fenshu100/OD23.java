package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD23 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String zimu = "abcdefghijklmnopqrstuvwxyz";
        int n = sc.nextInt();
        sc.nextLine();
        List<StringBuffer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String s = sc.nextLine();
            StringBuffer sb = new StringBuffer();
            int len = s.length();

            for (int j = 0; j < len; j++) {
                int pianyi = jiami(j);
                int index = (zimu.indexOf(s.charAt(j)) + pianyi) % 26;    //需要取余，防止pianyi值过大
                sb.append(zimu.charAt(index));
            }

            list.add(sb);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static int jiami(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 4;
        }
        return jiami(n - 1) + jiami(n - 2) + jiami(n - 3);
    }

}
