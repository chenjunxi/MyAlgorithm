package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
/*
* 过滤组合字符串
*
* */

class OD_13_new {
    public static ArrayList<String> res_str_list;

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String num_str = in.nextLine();
        String block_str = in.nextLine();
        //预设值
        HashMap<Character, String> num_char_map = new HashMap<Character, String>();

        num_char_map.put('0', "abc");
        num_char_map.put('1', "def");
        num_char_map.put('2', "ghi");
        num_char_map.put('3', "jkl");
        num_char_map.put('4', "mno");
        num_char_map.put('5', "pqr");
        num_char_map.put('6', "st");
        num_char_map.put('7', "uv");
        num_char_map.put('8', "wx");
        num_char_map.put('9', "yz");

        res_str_list = new ArrayList<String>();
        ArrayList<Character> char_list_temp = new ArrayList<Character>();
        dfs(num_str, char_list_temp, 0, num_char_map);

        int result_count = res_str_list.size();
        String output_str = "";
        for (String x : res_str_list) {
            // 过滤
            if (!check(x, block_str)) {
                output_str += x + " ";
            }
        }

        System.out.println(output_str.substring(0, output_str.length() - 1));
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

    // 递归求出所有可能的排列组合
    public static void dfs(String num_str, ArrayList<Character> list, int index, HashMap<Character, String> num_char_map) {
        if (index == num_str.length()) {
            String temp_str = "";
            for (int i = 0; i < list.size(); i++) {
                temp_str = temp_str + list.get(i);
            }
            res_str_list.add(temp_str);
            return;
        }

        for (char single_char : num_char_map.get(num_str.toCharArray()[index]).toCharArray()) {
            list.add(single_char);
            dfs(num_str, list, index + 1, num_char_map);
            list.remove(list.size() - 1);
        }
    }

}