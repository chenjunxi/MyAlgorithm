package com.leecode;

import java.util.ArrayList;
/*
* 括号生成
* l一定要大于等于r
* */
public class LeeCode22_2 {
    public static void main(String[] args) {

        int n = 2;
        ArrayList<String> list = new ArrayList<>();
        dfs("", n, n, list);

        System.out.println(list);
    }

    private static void dfs(String s, int l, int r, ArrayList<String> list) {

        if (l == 0 && r == 0) {
            list.add(s);
            return;
        }


        if (l < r) return;

        if (l > 0) {
            dfs(s + ")", l - 1, r, list);
        }

        if (r > 0) {
            dfs(s + "(", l, r - 1, list);
        }
    }
}
