package com.od.OD.OD130;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
/*
* 简单的解压缩算法
解压规则：A3=AAA {AB}3=ABABAB

{A3B1{C}3}3
输出
AAABCCCAAABCCCAAABCCC

* */
class OD_88 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        //防止最后一个字符是数字
        String str = in.nextLine();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c=='{') {
                stack.push("{");
            }else if (c=='}') {
                if (Character.isDigit(str.charAt(i+1))) {
                    int p = i+1;
                    while (p<str.length() && Character.isDigit(str.charAt(p))) p++;
                    int num = Integer.parseInt(str.substring(i+1,p));
                    StringBuilder sb = new StringBuilder();
                    while (!stack.peek().equals("{")){
                        String s = stack.pop();
                        sb.append(s);
                    }
                    stack.pop();
                    stack.push(repeat(sb.toString(), num));
                    i = p-1;
                }
            }else if (Character.isAlphabetic(c)){
                if (Character.isDigit(str.charAt(i+1))) {
                    int p = i+1;
                    while (p<str.length() && Character.isDigit(str.charAt(p))) p++;
                    int num = Integer.parseInt(str.substring(i+1,p));
                    stack.push(repeat(c+"",num));
                    i = p-1;
                }else {
                    stack.push(c+"");
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String str0 = sb.toString();
        sb = new StringBuilder();
        for (int i = str0.length()-1; i >=0 ; i--) {
            sb.append(str0.charAt(i));
        }
        System.out.println(sb.toString());
    }

    public static String repeat(String str, int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

}