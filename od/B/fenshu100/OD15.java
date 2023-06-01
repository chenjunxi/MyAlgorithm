package com.od.B.fenshu100;

import java.util.Scanner;

public class OD15 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split("#");
        int len = strings.length;
        long count = 0; //需要用long类型
        boolean isF = true;

        if (len == 4) {
            for (int i = 0; i < len; i++) {
                long n = Integer.valueOf(strings[i]);
                if (i == 0 && (n < 1 || n > 128)) { //第一节 1~128
                    isF = false;
                    break;
                } else if (n < 0 || n > 255) { //二、三、四节 0~255
                    isF = false;
                    break;
                }
                /**
                 * 首先使用把IP地址分成4个数字： 128 199 231 44
                 *
                 * 把每个数字转换为2进制，如果转换后这个数字对应的二进制数不够8位，在左侧补0： 10000000 11000111 11100111 00101100
                 */
                count += n << (8 * (3 - i));
            }
        } else {
            isF = false;
        }

        if (isF) {
            System.out.println(count);
        } else {
            System.out.println("invalid IP");
        }
    }
}
