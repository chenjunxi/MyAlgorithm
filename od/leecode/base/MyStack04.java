package com.leecode.base;

import java.util.ArrayDeque;

public class MyStack04 {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};

        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int s1 = list.pop() + list.pop();
                list.push(s1);
            } else if (s.equals("-")) {
                int s1 = -list.pop() + list.pop();
                list.push(s1);
            } else if (s.equals("*")) {
                list.push(list.pop() * list.pop());
            } else if (s.equals("/")) {
                int a = list.pop();
                int b = list.pop();
                list.push(b / a);
            } else {
                list.push(Integer.parseInt(s));
            }
        }

        System.out.println(list.pop());
    }
}
