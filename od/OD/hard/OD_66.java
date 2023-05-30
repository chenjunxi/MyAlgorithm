package com.od.OD.bei;

import java.util.Scanner;
/*简单的自动曝光
*
* 求平均值
* */
public class OD_66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int[] a = new int[n];
        float sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(s[i]);
            a[i] = num;
            sum += num;
        }

        //和与中位数的差值
        float ans = Math.abs(sum / n - 128) + 1; //加1防止 128 128 129 129情况

        System.out.println("ans:" + ans);
        System.out.println("sum:" + sum);
        int star, end;

        star = -((int) ans + 1);
        end = (int) ans + 1;


        int res = 0;
        for (int i = star; i <= end; i++) {
            float t = 0;
            for (int j = 0; j < n; j++) {

                int i1 = a[j] + i;
                if (i1 > 255) {
                    t += 255;
                } else if (i1 < 0) {
                    t += 0;
                } else {
                    t += i1;
                }
            }
            float dis = Math.abs(t / n - 128);
            //找出差值最小的k值
            if (dis < ans) {
                ans = dis;
                res = i;
            }
        }
        System.out.println(res);
    }
}
