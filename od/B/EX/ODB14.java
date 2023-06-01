package com.od.B.EX;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ODB14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());

        //告警之间的关系
        HashMap<String, HashSet<String>> alter_relations = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] arr = in.nextLine().split(" ");
            alter_relations.putIfAbsent(arr[1], new HashSet<>());
            alter_relations.get(arr[1]).add(arr[0]);
        }

        String[] all_alerts = in.nextLine().split(" ");
        HashSet<String> set = new HashSet<>(Arrays.asList(all_alerts));

        String result = "";
        for (String id2 : all_alerts) {
            if (!alter_relations.containsKey(id2) || Collections.disjoint(alter_relations.get(id2), set)) {
                result += id2 + " ";
            }
        }

        System.out.println(result.substring(0, result.length() - 1));
        return;
    }
}