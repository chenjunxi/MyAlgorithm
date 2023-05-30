package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

/*
* 真正的密码
示例1：
输入： h he hel hell hello o ok n ni nin ninj ninja
输出： ninja
说明： 按要求，hello、ok、ninja都是潜在密码。检查长度，hello、ninja是真正的密码。检查字典序，ninja是唯一真正密码。
示例2：
输入：
a b c d f
输出：
f
说明： 按要求，a b c d f 都是潜在密码。检查长度，a b c d f 是真正的密码。检查字典序，f是唯一真正密码。

思路：以首字母做为key存放map中，然后map元素存放在list中，list进行排序，list第一个元素就是答案
* */
public class OD_10 {
    public static int min_times;

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        demo01(strs);

    }

    //暴力
    private static void demo01(String[] strs) {

        // 将所有字符串放入哈希集合
        HashSet<String> word_set = new HashSet<>();
        word_set.addAll(Arrays.asList(strs));
        String true_pass_word = "";
        //按顺序检查每一个词
        for (String s : strs) {
            // 条件1：检查这个词所有以索引0开头的子串在数组中是否都有
            boolean flag = true;
            for (int i = 1; i < s.length(); i++) {
                // 以索引0开头的子串
                String sub_str = s.substring(0, i);
                if (!word_set.contains(sub_str)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                // 条件2：比较密码长度
                if (s.length() > true_pass_word.length())
                    true_pass_word = s;
                // 条件3：比较密码字典排序
                if (s.length() == true_pass_word.length() && s.compareTo(true_pass_word) > 0) {
                    true_pass_word = s;
                }
            }
        }
        System.out.println(true_pass_word);
    }
}
