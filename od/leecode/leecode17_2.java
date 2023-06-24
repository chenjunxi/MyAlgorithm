package com.leecode;

import java.util.ArrayList;
import java.util.List;
/*
电话号码的字母组合
* */
public class leecode17_2 {
    public static void main(String[] args) {

    }


    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        if (digits == null || digits.length() == 0) return list;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        dfs(list, temp, digits, numString, 0);

        return list;
    }

    private void dfs(List<String> list, StringBuilder temp, String digits, String[] numString, int index) {

        if (index == digits.length()) {
            list.add(temp.toString());
            return;
        }

        String s = numString[digits.charAt(index) - '0'];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            temp.append(c);
            dfs(list, temp, digits, numString, index + 1);
            temp.deleteCharAt(temp.length() - 1);

        }

    }

}
