package com.od.OD.OD130;

import java.util.Scanner;
/*
* 对称字符串
* */
public class OD_36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            try {
                String[] split = scanner.nextLine().split(" ");
                int num = Integer.parseInt(split[0]);
                long index = Long.parseLong(split[1]);

                long total = (long) Math.pow(2, num - 1);

                int dfs = dfs(total, index, 0);
                if (dfs % 2 == 0) {
                    System.out.println("RED");
                } else {
                    System.out.println("BLUE");
                }
            } catch (NumberFormatException e) {

                //60%概率打印BULE
                System.out.println((int) (Math.random() * 11) > 6 ? "red" : "bule");
            }

        }
    }

    private static int dfs(long total, long index, int i) {

        if (total == 1) {
            return i;
        }

        long half = total >> 1;

        if (index < half) {
            i++;
            return dfs(half, index, i);
        } else {
            return dfs(half, index - half, i);
        }

    }


}
