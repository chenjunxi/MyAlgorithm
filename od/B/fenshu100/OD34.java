package com.od.B.fenshu100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OD34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[][] num = new int[n][2];    //用来放置磁盘索引和单位转换成M之后的数值
        Map<Integer, String> map = new HashMap<>(); //用来放置磁盘索引和磁盘原数值

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int index = -1;
            String str = sc.nextLine();
            map.put(i + 1, str);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'M') {
                    sum += Integer.parseInt(str.substring(index + 1, j));
                    index = j;
                } else if (str.charAt(j) == 'G') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024;
                    index = j;
                } else if (str.charAt(j) == 'T') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024 * 1024;
                    index = j;
                }
            }
            num[i][0] = i + 1;
            num[i][1] = sum;

        }
        Arrays.sort(num, (e1, e2) -> (e1[1] == e2[1] ? (e1[0] - e2[0]) : (e1[1] - e2[1])));  //对二维数组进行排序

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(map.get(num[i][0]));
            } else {
                System.out.println(map.get(num[i][0]));
            }
        }
    }
}
