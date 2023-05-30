package com.od.OD.bei;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*羊狼农夫过河
农夫在的时候或者羊数量大于狼的时候，狼不会攻击羊，求在不损失羊的情况下，运输几次过河
5 3 3 5羊 3狼，船能载的数量
输出3
第一次 2只狼
第二次 3只羊
第三次 2羊1狼

 * */
public class OD_11 {

    public static int min = Integer.MAX_VALUE;
    public static int countY;   //羊的总数
    public static int countL;   //狼的总数

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int x = sc.nextInt();

        countY = m;
        countL = n;

        guohe(m, n, x, 0);

        if (m + n <= x) {     //一趟能运完
            System.out.println(1);
        } else if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }

    }

    public static void guohe(int m, int n, int x, int count) {

        if (m + n <= x) {     //剩下的能一次运完
            min = Math.min(min, count + 1);
        } else {
            for (int i = 0; i <= m; i++) {    //过河的羊的个数
                for (int j = 0; j <= n; j++) {    //过河的狼的个数
                    if ((i + j == 0) || (i + j > x)) {     //在船上的狼羊总数需要大于0且小于等于x
                        continue;
                    }
                    if (m - i != 0 && m - i <= n - j) {     //剩下的羊在不为0的情况下必须大于狼
                        continue;
                    }
                    if (countY - (m - i) != 0 && (countY - (m - i)) <= (countL - (n - j))) {      //对岸的羊在不为0的情况下必须要大于狼
                        continue;
                    }
                    guohe(m - i, n - j, x, count + 1);
                }
            }
        }

    }
}
