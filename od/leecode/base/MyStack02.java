package com.leecode.base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MyStack02 {
    public static void main(String[] args) {


        String s = "{[]}";
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        Deque<Character> list = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                list.push(')');
            } else if (ch == '{') {
                list.push('}');
            } else if (ch == '[') {
                list.push(']');
            } else if (list.isEmpty() || list.peek() != ch) {
                return false;
            } else {
                list.pop();
            }
        }

        return list.isEmpty();
    }
}
