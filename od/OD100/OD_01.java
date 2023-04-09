package com.od.OD.OD100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OD_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questiones = sc.nextLine().split(",");
        String[] answers = sc.nextLine().split(",");

        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < questiones.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (sort(questiones[i], answers[j])) {
                    res.add(answers[i]);
                } else if (dist(questiones[i], answers[j])) {
                    res.add(answers[i]);
                }
            }
        }

        if (res.size() > 0) {
            for (int i = 0; i < res.size() - 1; i++) {
                System.out.print(res.get(i) + ",");
            }
            System.out.print(res.get(res.size() - 1));
        } else {
            System.out.println("not found");
        }


    }


    //排序Arrays.sort
    public static boolean sort(String question, String answer) {
        if (question.length() != answer.length()) return false;

        char[] a = question.toCharArray();
        char[] b = answer.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b) ? true : false; //a.equal(b)行不通
    }

    //去重 快慢指针或者contains

    public static boolean dist(String question, String answer) {

        ArrayList<Character> list = new ArrayList<>();
        getDistList(question, list);

        ArrayList<Character> list1 = new ArrayList<>();
        getDistList(answer, list1);

        return list.equals(list1) ? true : false;

    }

    private static void getDistList(String question, ArrayList<Character> list) {
        for (int i = 0; i < question.length(); i++) {
            char c = question.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
            }
        }
    }
}
