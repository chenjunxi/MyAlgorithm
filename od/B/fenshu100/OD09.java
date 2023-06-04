package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*  逻辑技巧，需要背
* 座位调整
1,0,0,0,1
输出1


思路：统计遇到1之前有多少个0(不包含1附近的0),通过0的个数计算座位=Math.ceil(count/2)
分多种情况：
没有1的情况：这种最好计算之间就是=Math.ceil(count/2)
有1的情况：遇到1的时候0的数量都要置为0
                if (isFirst && count > 1) {
                    //如果是第一个1，且前面的0大于1，则除了1的左侧外都可以坐人
                    list.add(count - 1);
                } else if (count > 2) {
                    //因为前面1的右侧和后面1的左侧无法坐人
                    list.add(count - 2);
                }
最核心就是统计0的数量来确定位置数量
* */
public class OD09 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");

        int len = strings.length;
        List<Double> list = new ArrayList<>();
        //空位0的个数
        double count = 0;
        //是否是第一个1
        boolean isFirst = true;
        //是否有人占座
        boolean isHasOne = false;
        for (int i = 0; i < len; i++) {
            String str = strings[i];
            if (str.equals("1")) {
                if (isFirst && count > 1) {
                    //如果是第一个1，且前面的0大于1，则除了1的左侧外都可以坐人
                    list.add(count - 1);
                } else if (count > 2) {
                    //因为前面1的右侧和后面1的左侧无法坐人
                    list.add(count - 2);
                }
                count = 0;
                isFirst = false;
                isHasOne = true;
            } else {
                count++;
            }
            if (i == len - 1 && count > 1) {
                list.add(isHasOne ? count - 1 : count);
            }
        }

        int res = 0;
        for (double i : list) {
            res += Math.ceil(i / 2);
        }

        System.out.println(res);
    }
}
