package com.od.B.fenshu100;

import java.util.Scanner;

public class OD02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        String[] ss = s.split(",");

        int[] num = new int[ss.length];   //将输入放入整数数组中

        for (int m = 0; m < ss.length; m++) {
            num[m] = Integer.parseInt(ss[m]);
        }

        int max = 0;    //最大面积

        for (int n = 1; n < num.length; n++) {
            int min = num[n]; //假设当前挡板为最小挡板
            int temp = n - 1; //前一个挡板下标
            for (int i = 1; i <= n; i++) {
                /**
                 * 循环计算当前挡板到前面i个挡板的面积并求出最大值
                 */
                min = Math.min(min, num[temp--]);   //min 求出前挡板到前面i个挡板最小高度
                max = Math.max(min * i, max);  //min*i 求出前挡板到前面i个挡板的面积
            }
        }

        System.out.println(max);

    }
}
