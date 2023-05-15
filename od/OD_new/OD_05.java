package com.od.OD.OD130;

import java.util.*;

/*
* 等和子数组最小和 和MVP争夺题类型
7
4,3,2,3,5,2,1
* */
public class OD_05 {
    public static void main(String[] args) {

//        int[] ints = {3, 2, 6, 4, 4, 5};
        int[] ints = {4, 3, 2, 3, 5, 2, 1};

        Arrays.sort(ints);
        int min = ints[ints.length - 1];      //最小平均值为数组最大值
        int max = Arrays.stream(ints).sum();

        int res = 0;
        for (int i = min; i < max; i++) {
            if (max % i == 0) {     //满足整除的情况下才能进行平分
                int[] temp = new int[max / i];    //桶的个数
                if (handle(ints, 0, temp, i)) {
                    res = i;
                    break;
                }
            }
        }

        System.out.println(res);
    }


    public static boolean handle(int[] nums, int index, int[] bucket, int weight) {
        /*
         * index == nums.length说明都放完了
         */
        if (index == nums.length) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            //多个桶重量一样,前面已经试了不要重复试,此处可能不好理解
            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }
            // 满足条件才能放入
            if (bucket[i] + nums[index] <= weight) {
                // 放入
                bucket[i] = bucket[i] + nums[index];
                // 后续递归放入剩余的物体
                if (handle(nums, index + 1, bucket, weight)) {
                    return true;
                }
                //上面的策略失败了,就回退,继续尝试后面的策略
                bucket[i] = bucket[i] - nums[index];
            }
        }

        return false;
    }

}
