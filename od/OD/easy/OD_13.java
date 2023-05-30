package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
/*
* 过滤组合字符串
电话号码组合题的延伸
先通过dfs回溯组合，然后过滤指定的字符串
78
ux
组合有 uw ux vx vw 过滤掉ux
输出 uw vx vw

* */

class OD_13 {


    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String target = in.nextLine();
        String block_str = in.nextLine();
        //预设值
        String[] numStr = {"abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uv", "wx", "yz"};


        ArrayList<String> list = new ArrayList<>();
        StringBuilder path = new StringBuilder();


        dfs(list, path, numStr, target, 0);


        String output_str = "";
        for (String x : list) {
            // 过滤
            if (!check(x, block_str)) {
                output_str += x + " ";
            }
        }

        System.out.println(output_str.substring(0, output_str.length() - 1));
    }

    private static void dfs(ArrayList<String> list, StringBuilder path, String[] numStr, String target, int i) {

        if (i == target.length()) {
            list.add(path.toString());
            return;

        }

        String s = numStr[target.charAt(i) - '0'];
        for (int j = 0; j < s.length(); j++) {
            path.append(s.charAt(j));
            dfs(list, path, numStr, target, i + 1);
            path.deleteCharAt(path.length() - 1);
        }

    }

    //判断字符是否全部包含
    public static boolean check(String string1, String string2) {
        Set<Character> set1 = new HashSet<Character>();
        for (int i = 0; i < string1.length(); i++) {
            set1.add(string1.charAt(i));
        }

        Set<Character> set2 = new HashSet<Character>();
        for (int i = 0; i < string2.length(); i++) {
            set2.add(string2.charAt(i));
        }

        for (Character single_char : set2) {
            if (!set1.contains(single_char)) {
                return false;
            }
        }

        return true;

    }

}