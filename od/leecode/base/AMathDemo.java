package com.leecode.base;

public class AMathDemo {
    public static void main(String[] args) {


    }

    //判断素数的逻辑：本身i分别去除2到MatMath.sqrt(i) 如果有整除就不是素数
    private static void sushu() {
        int count = 0;
        for (int i = 101; i < 200; i++) {

            boolean flag = false;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                count++;
                System.out.println(i);
            }

        }

        System.out.println(count);
    }

    //求两个数的最大公约数
    //最小被公倍数：a*b/最大公约数
    private static int gongyueshu(int a, int b) {


        int yushu = 0;
        while (a % b != 0) {
            yushu = a % b;
            a = b;
            b = yushu;
        }

        return b;
    }


}
