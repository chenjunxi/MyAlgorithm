package com.od.OD.OD100;

import java.util.Scanner;

public class OD_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder reslut = new StringBuilder();
        int slow = 0, fast = 0;

        while (fast < input.length()) {

            char c = input.charAt(fast);
            //当快指针遇到字符的时候
            if (c == ' ' || c == ',' || c == '.' || c == '?') {

                //如果slow当前字符是字母的时候
                if (Character.isLetter(input.charAt(slow))) {
                    StringBuilder substring = new StringBuilder(input.substring(slow, fast));
                    reslut.append(substring.reverse()).append(c);
                } else {
                    reslut.append(c);
                }

                slow = fast + 1; //慢指针移动

            }
            fast++;

            //若字符串没有以字符结尾的时候，当快指针达到最后一位也要反转处理
            if (fast == input.length()) {
                StringBuilder substring = new StringBuilder(input.substring(slow, fast));
                reslut.append(substring.reverse());
            }
        }


        System.out.println(reslut.toString());
    }
}
