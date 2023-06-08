package com.od.B.fenshu100;


import java.util.*;
import java.util.stream.Collectors;

/**
 * VLAN资源池
 * <p>
 * 思路使用状态数组
 */
public class OD52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = scanner.nextInt();
        TreeSet<Integer> sin = new TreeSet<>();
        HashMap<Integer, List<Integer>> dou = new HashMap<>();
        String[] split = s.split(",");
        for (int j = 0; j < split.length; j++) {
            if (!split[j].contains("-")) {
                int num = Integer.valueOf(split[j]);
                if (num != i) {
                    ArrayList<Integer> aa = new ArrayList<>();
                    aa.add(num);
                    dou.put(num, aa);
                }
            } else {

                String[] split1 = split[j].split("-");
                int start = Integer.valueOf(split1[0]);
                int end = Integer.valueOf(split1[1]);
                int k = start;
                ArrayList<Integer> integers1 = new ArrayList<>();
                if (start == i) {
                    start++;
                    k = start;
                    while (k <= end) {
                        integers1.add(k);
                        k++;
                    }
                    dou.put(start, integers1);
                } else if (end == i) {
                    end--;
                    while (k <= end) {
                        integers1.add(k);
                        k++;
                    }
                    dou.put(start, integers1);
                } else if (start < i && i < end) {
                    for (int l = start; l < i; l++) {
                        integers1.add(l);
                    }
                    dou.put(start, integers1);
                    ArrayList<Integer> integers2 = new ArrayList<>();
                    for (int l = i + 1; l <= end; l++) {
                        integers2.add(l);
                    }
                    dou.put(i + 1, integers2);
                } else {
                    for (int l = start; l <= end; l++) {
                        integers1.add(l);
                    }
                    dou.put(start, integers1);
                }
            }
        }
        String o = "";
        Set<Integer> integers = dou.keySet();
        List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
        for (Integer aa : collect) {
            List<Integer> list = dou.get(aa);
            if (list.size() == 1) {
                o = o + list.get(0) + ",";
            } else {
                o = o + list.get(0) + "-" + list.get(list.size() - 1) + ",";
            }
        }
        String substring = o.substring(0, o.length() - 1);
        System.out.println(substring);
    }
}

