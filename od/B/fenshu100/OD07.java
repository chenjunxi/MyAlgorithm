package com.od.B.fenshu100;

import scala.xml.Null;

import java.util.*;

/*
* 选修课 题目又长又臭，诸多要求
要求很简单找出同时修两门选修课的同学，麻烦地方是输出。重点考排序比较，千万别犯字符串数字比较

输出要求：首先输出班级编号较小的班级编号，第二行就是这个班级同时修2门选修课的学号，按成绩降序，成绩相同就按学号升序……
输入：

01202021,75;01201033,95;01202008,80;01203006,90;01203088,100
01202008,70;01203088,85;01202111,80;01202021,75;01201100,88
输出：
01202
01202008;01202021
01203
01203088

思路:使用map记录，学号作为key，list存放成绩，list大小=2就是修了2门课。

再使用treemap存放修了两门课的同学，班级编号作为key，value是一个list存放同学的数组{成绩，学生ID}

遍历treemap，就行了。自定义同一个班级同学的排序输出

* */
public class OD07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] one = sc.nextLine().split(";");
        String[] two = sc.nextLine().split(";");


        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        getMap(one, map);
        getMap(two, map);
        TreeMap<Integer, ArrayList<String[]>> res = new TreeMap<>();


        for (Map.Entry<String, ArrayList<Integer>> m : map.entrySet()) {
            ArrayList<Integer> list = m.getValue();
            if (list.size() == 2) {
                int sorce = 0;
                for (int i : list) {
                    sorce += i;
                }


                String key = m.getKey();
                int classnum = Integer.valueOf(key.substring(0, 5));
                String[] ints = {String.valueOf(sorce), key};


                if (res.containsKey(classnum)) {
                    ArrayList<String[]> ints1 = res.get(classnum);
                    ints1.add(ints);
                    res.put(classnum, ints1);
                } else {
                    ArrayList<String[]> list1 = new ArrayList<>();
                    list1.add(ints);
                    res.put(classnum, list1);
                }
            }
        }

        if (res.size() == 0) {
            System.out.println("NULL");
            return;
        }

        for (Map.Entry<Integer, ArrayList<String[]>> m : res.entrySet()) {

            ArrayList<String[]> list = m.getValue();
            System.out.println(list.get(0)[1].substring(0, 5));

            //定义排序
            list.sort((a, b) -> {
                Integer s1 = Integer.valueOf(a[0]);
                Integer s2 = Integer.valueOf(b[0]);
                Integer num1 = Integer.valueOf(a[1].substring(5));
                Integer num2 = Integer.valueOf(b[1].substring(5));
                if (s1 != s2) return s2 - s1;
                return num1 - num2;

            });
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    System.out.print(list.get(i)[1]);
                } else {
                    System.out.print(list.get(i)[1] + ";");
                }

            }
            System.out.println();

        }

    }

    private static void getMap(String[] arr, HashMap<String, ArrayList<Integer>> map) {
        for (int i = 0; i < arr.length; i++) {

            String s = arr[i];
            String[] split = s.split(",");

            String key = split[0];
            Integer cj = Integer.valueOf(split[1]);

            if (map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key);
                list.add(cj);
                map.put(key, list);

            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(cj);
                map.put(key, list);
            }
        }
    }

}
