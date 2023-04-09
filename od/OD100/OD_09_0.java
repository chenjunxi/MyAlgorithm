package com.od.OD.OD100;


import java.util.*;

//主要知识点集合操作，set.retainAll求公共部分 list.set(index,elem)
public class OD_09_0 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        if (M > 10) {
            System.out.println("[[]]");
        } else {
            ArrayList<TreeSet<Integer>> list = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                String[] input = sc.nextLine().split(",");
                int length = input.length;

                if (length > 100 || length < 1) { //边界条件
                    System.out.println("[[]]");
                    return;
                }

                TreeSet<Integer> set = new TreeSet<>();

                if (length == 1) {
                    set.add(Integer.parseInt(input[0]));
                    list.add(set);
                } else {
                    for (String s : input) {
                        set.add(Integer.parseInt(s));
                    }

                    list.add(set);
                    merge(set, list, list.size() - 1);
                }
            }


            System.out.println(list);
        }
    }

    private static void merge(TreeSet<Integer> set, ArrayList<TreeSet<Integer>> list, int index) {


        for (int i = 0; i < list.size(); i++) {
            TreeSet<Integer> elemSet = list.get(i);

            if (i == index || elemSet.size() == 1) continue; //减少判断，只有一个元素肯定用合并的

            HashSet<Integer> tempSet = new HashSet<>(); //因为不需要排序此处使用性能比treeset快的hashset
            tempSet.addAll(elemSet);
            tempSet.retainAll(set);

            if (tempSet.size() >= 2) {
                set.addAll(elemSet);

                int indexSmall = index > i ? i : index;
                int indexBig = indexSmall == i ? index : i;

                list.set(indexSmall, set); //修改前面的元素值
                list.remove(indexBig);  //删掉后面的元素

                merge(set, list, indexSmall);
            }

        }

    }
}
