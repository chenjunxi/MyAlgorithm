package com.od.B.fenshu100;

import java.util.*;

/*
 *用TreeMap统计，位数做key，list存放数字，list升序排序，全排列，需要对数组进行换位置

21,30,62,5,31
 * */
public class OD20 {
    public static List<Integer> list = new ArrayList<>();

    public static int mix = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(",");
        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();

        for (String str : strings) {
            int length = str.length();

            if (map.containsKey(length)) {
                ArrayList<String> list = map.get(length);
                list.add(str);
                map.put(length, list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(length, list);
            }

        }

        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<String>> m : map.entrySet()) {
            ArrayList<String> value = m.getValue();
            Collections.sort(value);
            list.addAll(value);
        }


        int count = Math.min(3, list.size());

        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = Integer.valueOf(list.get(i));
        }


        dfs(ints, 0, count);

        System.out.println(mix);
    }

    private static void dfs(int[] ints, int cursor, int end) {

        if (cursor == end) {
            String s = "";
            for (int i : ints) {
                s += i;
            }
            mix = Math.min(mix, Integer.parseInt(s));
            return;
        }
        for (int i = cursor; i < end; i++) {
            swap(ints, cursor, i);
            dfs(ints, cursor + 1, end);
            swap(ints, cursor, i);
        }
    }


    //原始方法
    private static void DEMO() {
        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(",");

        int slen = strings.length;
        int res;

        if (slen == 1) {    //考虑到只有一个数的情况
            res = Integer.valueOf(strings[0]);
        } else {
            List<Integer> numList = new ArrayList<>();

            for (int i = 0; i < slen; i++) {
                numList.add(Integer.valueOf(strings[i]));
            }
            Collections.sort(numList);  //对数组进行排序
            int numsLen;
            if (slen == 2) {    //区别只有两个数的情况
                numsLen = 2;
            } else {
                numsLen = 3;
            }

            int[] ints = new int[numsLen];
            for (int i = 0; i < numsLen; i++) {
                ints[i] = numList.get(i);
            }
            fullArr(ints, 0, numsLen);   //对数字进行全排列找出最小值

            res = Collections.min(list);
        }
        System.out.println(res);
    }

    /**
     * 对ints中的数字进行全排列
     *
     * @param ints
     * @param cursor
     * @param end
     */
    public static void fullArr(int[] ints, int cursor, int end) {

        if (cursor == end) {
            String s = "";
            for (int i : ints) {
                s += i;
            }
            list.add(Integer.parseInt(s));
        } else {
            for (int i = cursor; i < end; i++) {
                swap(ints, cursor, i);
                fullArr(ints, cursor + 1, end);
                swap(ints, cursor, i);
            }
        }
    }

    public static void swap(int[] ints, int a, int b) {

        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;

    }
}
