package com.leecode.base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
删除相邻相同元素
遍历元素 和栈顶元素相同的就删除
* */
public class MyStack03 {
    public static void main(String[] args) {
        String str = "abbacac";


        ArrayDeque<Character> list = new ArrayDeque<>();

        list.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!list.isEmpty() && ch == list.peek()) {
                list.pop();
            } else {
                list.push(ch);
            }
        }

        while (!list.isEmpty()) {
            System.out.println(list.pop());
        }


    }
}
