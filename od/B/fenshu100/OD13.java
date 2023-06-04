package com.od.B.fenshu100;

import java.lang.reflect.Array;
import java.util.*;

/*
* 斗地主顺子
顺子不包含2,输入不会存在大小王
如果有多个顺子，按第一张牌的大小升序

2 9 J 10 3 4 K A 7 Q A 5 6

输出
3 4 5 6 7
9 10 J Q K A


思路：J Q K A 转成 对应数字 11 12 13 14
把牌转成状态数组：[0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2]
剩下的事就是双循环遍历连续不为0的数字了


* */
public class OD13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine()
                .replaceAll("J", "11")
                .replaceAll("Q", "12")
                .replaceAll("K", "13")
                .replaceAll("A", "14")
                .split(" ");

        int len = s.length;


        int[] nums = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();


        int[] ints = new int[15];

        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]]++;
        }

        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        for (int i = 3; i < ints.length; i++) {
            if (ints[i] == 0) continue;
            int count = 0;
            ArrayList<Integer> temp = new ArrayList<>();

            temp.add(i);
            for (int j = i + 1; j < ints.length; j++) {

                if (ints[j] == 0) {
                    count = j - i;
                    i = j;
                    break;
                } else if (j == ints.length - 1) {
                    count = j - i + 1;
                    i = j;
                    temp.add(j);
                    break;
                } else {
                    temp.add(j);
                }
            }
            if (count >= 5) {
                list1.add(temp);
            }
        }

        if (list1.size() == 0) {
            System.out.println("NO");
        } else {
            for (ArrayList<Integer> list : list1) {
                String res = "";
                for (int i = 0; i < list.size(); i++) {
                    Integer integer = list.get(i);

                    res += integer + " ";
                }

                String ans = res.substring(0, res.length() - 1)
                        .replaceAll("11", "J")
                        .replaceAll("12", "Q")
                        .replaceAll("13", "K")
                        .replaceAll("14", "A");
                System.out.println(ans);

            }
        }

    }


}
