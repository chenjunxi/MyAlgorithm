package com.od.B.fenshu100;

import java.util.*;

public class OD16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();

        //因为题目要求先去除非字母的符号
        String newStr = "";
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isLetter(c)) {
                newStr += c;
            }
        }

        int len = newStr.length();
        //连续字符的个数
        int total = 1;
        //最后一个字符
        char temp = Character.toLowerCase(newStr.charAt(len - 1));
        //字符的集合
        List<Letter> list = new ArrayList<>();
        /**
         * key：字符
         * value：字符出现的次数
         */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = len - 2; i >= 0; i--) {
            //当前字符转换成小写
            char c = Character.toLowerCase(newStr.charAt(i));
            if (temp == c) {
                //相同字符串
                total++;
            } else {

                if (total == 1) {
                    //字符只有一个，说明是非连续的
                    //后面又这个字符则需要统计其次数（因为自己不算，所以需要-1）
                    total += map.getOrDefault(temp, 0) - 1;
                    map.put(temp, total + 1);
                } else {
                    //连续字符
                    map.put(temp, total);
                }

                Letter letter = new Letter(temp, total);
                list.add(letter);
                temp = c;
                total = 1;

            }
            //第一个字符需要另外处理
            if (i == 0) {
                if (total == 1) {
                    total += map.getOrDefault(temp, 0) - 1;
                }
                Letter letter = new Letter(temp, total);
                list.add(letter);
            }
        }

        list.sort((a, b) -> {
            if (a.total == b.total) {
                return a.name - b.name;
            }
            return b.total - a.total;
        });

        String res = "";
        for (Letter letter : list) {
            res += String.valueOf(letter.name) + letter.total;
        }

        System.out.println(res);

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
