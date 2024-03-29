package com.od.OD.OD100;


import java.util.*;

//关联端口组合
//主要知识点集合操作，set.retainAll求公共部分 list.set(index,elem)
public class OD_09 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        if (M > 10) {
            System.out.println("[[]]");
        } else {
            List<Set<Integer>> list = new ArrayList<>();
            sc.nextLine();

            for (int i = 0; i < M; i++) {
                String[] strings = sc.nextLine().split(",");
                if (strings.length > 100) {
                    System.out.println("[[]]");
                    return;
                }

                int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

                Set<Integer> set = new TreeSet<>();
                if (nums.length == 1) {    //只有一个元素直接添加
                    set.add(nums[0]);
                    list.add(set);
                } else {
                    for (int num : nums) {
                        set.add(num);   //数组转化为set集合
                    }
                    list.add(set);
                    merge(set, list, list.size() - 1);
                }
            }

            System.out.println(list);
        }
    }


    public static void merge(Set<Integer> set, List<Set<Integer>> list, int index) {

        for (int i = 0; i < list.size(); i++) {

            if (i == index) {
                continue;
            }

            Set<Integer> setIndex = list.get(i);     //当前索引的set集合

            Set<Integer> setTemp = new TreeSet<>();
            setTemp.addAll(set);
            setTemp.retainAll(setIndex);    //求出set和setIndex的交集

            if (setTemp.size() >= 2) {  //交集大于等于2则合并

                set.addAll(setIndex);   //set与setIndex合并

                int beforeIndex = index > i ? i : index;    //求出排在前面的index
                int afterIndex = beforeIndex == index ? i : index;  //靠后的位置

                list.remove(afterIndex);     //合并的两个set进行删除，先删除后面的一个
                list.remove(beforeIndex);
                list.add(beforeIndex, set);    //将新的set放在前面位置

                merge(set, list, beforeIndex);     //将新建的组合再进行判断合并

            }
        }
    }
}
