package com.od.OD.OD130;

import java.util.Scanner;
/*
*几何平均值最大子数组
* */
class OD_111_new {
    public static int sub_arr_pos = 0;
    public static int sub_arr_size = 0;
    public static int N;
    public static int L;
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        L = in.nextInt();

        // 最大 / 最小值 / 乘积
        double min_num = Integer.MAX_VALUE;
        double max_num = Integer.MIN_VALUE;
        double result = 1;

        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextDouble();
            min_num = Math.min(min_num, nums[i]);
            max_num = Math.max(max_num, nums[i]);
            if (i<L) {
                result *= nums[i];
            }
        }

        //二分法找几何平均数，注意double数相等的判断方法,leetcode是10^-10次方
        while (max_num - min_num >= Math.pow(10, -10)) {
            double mid_num = (min_num + max_num) / 2;

            if (cal(result, nums, mid_num)) {
                min_num = mid_num;
            } else {
                max_num = mid_num;
            }
        }
        System.out.print(sub_arr_pos);
        System.out.print(" ");
        System.out.print(sub_arr_size);
    }

    public static boolean cal(double result,double[] nums, double mid_num) {
        // 利用中间值来进行几何平均值计算
        result = result / Math.pow(mid_num, L);

        //如果大于1，说明[0~L-1]已经大于这个临时的最大几何平均值mid_num, 可以直接返回。
        if (result >= 1) {
            sub_arr_pos = 0;
            sub_arr_size = L;
            return true;
        }

        //否则需要往后延长，继续增加长度，用前缀的方式来保存前面的子数组的乘积
        double pre_result = 1;
        double min_pre_result = Integer.MAX_VALUE;
        int min_pre_result_pos = 0;

        for (int i = L; i < N; i++) {
            result *= nums[i] / mid_num;
            pre_result *= nums[i - L] / mid_num;

            if (pre_result < min_pre_result) {
                min_pre_result = pre_result;
                min_pre_result_pos = i - L;
            }

            if (result / min_pre_result >= 1) {
                sub_arr_pos = min_pre_result_pos + 1;
                sub_arr_size = i - min_pre_result_pos;
                return true;
            }
        }

        return false;
    }


}