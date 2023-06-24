package com.leecode;

import java.util.ArrayList;

public class leecode06 {
    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;

        ArrayList<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : list) {
            sb.append(row);
        }
        return sb.toString();
    }
}
