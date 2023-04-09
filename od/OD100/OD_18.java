package com.od.OD.OD100;

import java.util.Scanner;

public class OD_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        String[] splitA = a.split("\\.");
        String[] splitB = b.split("\\.");

        //主次比较
        for (int i = 0; i < 2; i++) {
            int A = Integer.parseInt(splitA[i]);
            int B = Integer.parseInt(splitB[i]);
            if (A != B) {
                System.out.println(A > B ? a : b);
                return;
            }
        }

        //增量版本-里程碑版本
        if (splitA.length > 2 && splitB.length > 2) {
            String[] split_A = splitA[2].split("-");
            String[] split_B = splitB[2].split("-");

            if (split_A[0] != split_B[0]) {
                System.out.println(Integer.parseInt(split_A[0]) > Integer.parseInt(split_B[0]) ? a : b);
                return;
            }

            if (split_A.length == 2 && split_B.length == 2) {
                System.out.println(split_A[1].compareTo(split_B[1]) > 0 ? a : b);
            } else {
                System.out.println(split_A.length > split_B.length ? a : b);
            }

        } else {
            System.out.println(splitA.length >= splitB.length ? a : b);
        }
    }
}
