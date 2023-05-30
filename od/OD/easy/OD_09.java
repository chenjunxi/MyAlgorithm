package com.od.OD.OD130;

import java.util.Scanner;

/*
 * 最小调整数量
 *
 * */
public class OD_09 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int cnt = 0;
        int unRemoveNum = 0;
        boolean isResver = false;
        for (int i = 0; i < 2 * n; i++) {
            String[] str = in.nextLine().split(" ");
            if (str.length == 3) {
                if (unRemoveNum != 0) {
                    if (str[0].equals("head") && !isResver) {
                        isResver = true;
                    }
                }
                unRemoveNum++;
            }
            if (str.length == 1) {
                unRemoveNum--;
                cnt += isResver ? 1 : 0;
                isResver = false;
            }
        }
        System.out.println(cnt);
    }

}
