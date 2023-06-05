package com.od.B.fenshu100;

import java.util.*;

/*
* 字符串摘要
使用map记录字母的数量，每次遍历都要更新map对应value值
bAaAcBb
a3b2b2c0
bAaAcBc

思路:
使用map记录字母的数量，每次遍历都要更新map对应value值
list 存放Letter类，然后单独最最后一个元素处理
然后自定义排序
* */
public class OD16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();

        //因为题目要求先去除非字母的符号
        String newStr = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetter(c)) {
                newStr += Character.toLowerCase(c);
                map.put(Character.toLowerCase(c), map.getOrDefault(Character.toLowerCase(c), 0) + 1);
            }
        }

        ArrayList<Letter> list = new ArrayList<>();
        for (int i = 0; i < newStr.length() - 1; i++) {
            char cur = newStr.charAt(i);
            char next = newStr.charAt(i + 1);
            if (cur != next) {
                Integer count = map.get(cur);
                list.add(new Letter(cur, count - 1));
                map.put(cur, count - 1);
            } else {//连续相同字母的时候
                int j = i + 1;
                while (j < newStr.length()) {
                    if (cur != newStr.charAt(j) || j == newStr.length() - 1) {
                        break;
                    }
                    j++;
                }
                list.add(new Letter(cur, j - i));
                map.put(cur, map.get(cur) - (j - i));
                i = j - 1; //指针跳跃,防止重复计算
            }

        }

        //单独处理最后一个元素
        Letter letter = list.get(list.size() - 1);
        char c = newStr.charAt(newStr.length() - 1);
        if (letter.name == c) {
            list.set(list.size() - 1, new Letter(c, letter.total + 1));
        } else {
            list.add(new Letter(c, 0));
        }

        //自定义排序
        list.sort((a, b) -> {

            if (a.total != b.total) return b.total - a.total;
            return a.name - b.name;
        });

        for (Letter l : list) {
            System.out.print(l.name + "" + l.total);
        }

    }

    static class Letter {

        char name;
        int total;

        public Letter(char name, int total) {
            this.name = name;
            this.total = total;
        }

    }
}
