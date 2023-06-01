package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OD26 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");

        List<Word> letterList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            //防止空格
            if (str.equals("")) {
                continue;
            }
            //数字开始的下标
            int index = 0;
            for (int j = 0; j < str.length(); j++) {
                if (Character.isDigit(str.charAt(j))) {
                    index = j;
                    break;
                }
            }
            //字母部分
            String letter = str.substring(0, index);
            //顺序部分
            int num = Integer.parseInt(str.substring(index));
            Word word = new Word(letter, num);
            letterList.add(word);
        }

        letterList.sort((a, b) -> {
            return a.num - b.num;
        });

        String res = "";
        for (Word word : letterList) {
            res += word.letter + " ";
        }

        System.out.println(res.substring(0, res.length() - 1));
    }

    static class Word {

        String letter;
        int num;

        public Word(String letter, int num) {

            this.letter = letter;
            this.num = num;

        }

    }
}