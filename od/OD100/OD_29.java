package com.od.OD.OD100;

import java.util.Scanner;

//循环A字符串，匹配过的位置赋值为0，当完成一次匹配就从头开始匹配
public class OD_29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        char[] charsA = A.toCharArray();

        int indexA = 0;
        int indexB = 0;
        int count = 0;
        while (indexA < A.length()) {

            if (charsA[indexA] == '0') {
                indexA++;
                continue;
            }

            if (charsA[indexA] == B.charAt(indexB)) {
                charsA[indexA] = '0';
                indexB++;
            }

            if (indexB == B.length()) {
                count++;
                indexB = 0;
                indexA = 0;
            } else {
                indexA++;
            }

        }
        System.out.println(count);
    }
}
