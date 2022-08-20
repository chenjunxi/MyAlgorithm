package com.od.exam;

import java.util.Scanner;

public class ZT06 {
    private static String[] content;
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String[] num = sc.nextLine().split(" ");
            System.out.println(reverseWords(input, Integer.parseInt(num[0]), Integer.parseInt(num[1])));
        } catch (Exception e) {
            System.out.println("EMPTY");
        }
    }
    private static String reverseWords(String str,int start,int end){
        String[] content = str.split(" ");
        while (start < end){
            String temp = "";
            temp = content[end];
            content[end] = content[start];
            content[start] = temp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < content.length; i++) {
            sb.append(content[i]);
            if (i+1 < content.length){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
