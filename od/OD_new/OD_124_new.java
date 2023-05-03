package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
*
*猜数字
* */
class OD_124_new {
    public static void main(String[] args) {
        // 处理输入
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        String[][] input_pairs=new String[n][2];
        for (int i = 0; i < n; i++) {
            input_pairs[i][0]=in.next();
            input_pairs[i][1]=in.next();
        }
        ArrayList<String> result = new ArrayList<>();

        //暴力遍历所有可能数字
        List<Character> chars = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (Character c1 : chars) {
            for (Character c2 : chars) {
                for (Character c3 : chars) {
                    for (Character c4 : chars) {
                        String temp = new String(new char[] {c1, c2, c3, c4});
                        if (check(temp, input_pairs)) {
                            result.add(temp);
                        }
                    }
                }
            }
        }

        // 多个可能的正确答案或者都不满足就是无效的
        if (result.size() != 1) {
            System.out.println("NA");
        } else {
            System.out.println(result.get(0));
        }
    }

    // 判断当前组合是否满足所有的猜测
    public static boolean check(String temp, String[][] input_pairs) {
        for (String[] pair : input_pairs) {
            if (!pair[1].equals(single_check(pair[0], temp))) {
                return false;
            }
        }
        return true;
    }

    // 获取当前猜测组合的猜测结果
    public static String single_check(String input, String temp) {
        int countA = 0;
        int countB = 0;

        int[] temp_arr = new int[10];
        int[] input_arr = new int[10];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == temp.charAt(i)) {
                countA++;
            } else {
                temp_arr[temp.charAt(i) - '0']++;
                input_arr[input.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            countB += Math.min(temp_arr[i], input_arr[i]);
        }

        return Integer.toString(countA) + "A"+ Integer.toString(countB) + "B";
    }

}