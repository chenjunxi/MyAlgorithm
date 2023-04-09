package com.od.OD.OD100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//排序 切割 排序 比较
public class OD_40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String context = sc.nextLine();
        String word = sc.nextLine();

        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        int left = 0, right = word.length();
        int count = 0;

        while (right <= context.length()) {
            String substring = context.substring(left, right);
            char[] charsTemp = substring.toCharArray();

            Arrays.sort(charsTemp);
            if (Arrays.equals(chars, charsTemp)) {
                count++;
            }

            left++;
            right++;
        }

        System.out.println(count);
    }

    public static boolean check(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
