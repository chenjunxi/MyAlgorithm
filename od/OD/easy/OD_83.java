package com.od.OD.OD130;

import java.util.Scanner;
/*光伏场地建设
*
*
* */
public class OD_83 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split("\\s+");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);
        int len = Integer.parseInt(split[2]);
        int wh = Integer.parseInt(split[3]);
        int result = 0;
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            String nextLine = scanner.nextLine();
            String[] splitFi = nextLine.split("\\s+");
            for (int j = 0; j < col; j++) {
                int aa = Integer.parseInt(splitFi[j]);
                arr[i][j] = aa;
            }
        }
        for (int i = 0; i + len <= row; i++) {
            for (int j = 0; j + len <= col; j++) {
                int sum = 0;
                for (int k = i; k < i + len; k++) {
                    for (int l = j; l < j + len; l++) {
                        sum = sum + arr[k][l];
                    }
                }
                if (sum >= wh) {
                    result = result + 1;
                }
            }
        }
        System.out.println(result);
    }
}
