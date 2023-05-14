package com.od.OD.OD130;

import java.math.BigDecimal;
import java.util.Scanner;

/*
*几何平均值最大子数组
3 2 数组长度为3 ，至少子数组长度为2
2  数组第一个元素
2
3
输出：1 2
长度至少为2的子数组为[2,3][2,3][2,2,3],几何平均值最大为[2,3]输出其开始位置1和长度2
若有多个最大值，先长度小优先，若长度一样，位置靠前优先
重点几何平均值怎么算? [2,3] 的几何平均值等于 Math.pow(2*3, 1/数组长度)

* */
class OD_111 {
    public static double max;   //最大几何平均值
    public static int index;    //正在处理数据的索引

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        double[] doubles = new double[N];
        for (int i = 0; i < N; i++) {
            doubles[i] = sc.nextDouble();
        }

        int resIndex = 0;
        int resLen = 0;
        for (int i = L; i <= N; i++) {
            if (handle(i, doubles)) {
                resIndex = index;
                resLen = i;
            }
        }

        System.out.println(resIndex + " " + resLen);
    }

    /**
     * 是否满足最大几何平均值
     *
     * @param len     子数组长度
     * @param doubles 输入的正数数组
     * @return
     */
    public static boolean handle(int len, double[] doubles) {

        double maxInLen = 1;    //len长度数组的最大乘积
        for (int i = 0; i < len; i++) {
            BigDecimal num1 = new BigDecimal(String.valueOf(maxInLen));
            BigDecimal num2 = new BigDecimal(String.valueOf(doubles[i]));
            maxInLen = num1.multiply(num2).doubleValue();   //初始化maxInLen
        }

        index = 0;      //初始化索引位置
        double count = maxInLen;    //各数组中数字的乘积
        for (int i = len; i < doubles.length; i++) {
            //如例1： 1 2 3 长度为2
            //第一个子数组{1,2}  乘积为 1 * 2 = 2
            //第二个子数组{2,3}  乘积为 2 * 3 / 1 = 6
            //相当于滑窗，第一个数组的乘积 * 紧接着后面的第一个数 / 第一个数组的第一个数 = 紧接着后面的数组的乘积
            count *= doubles[i] / doubles[i - len];
            if (count > maxInLen) {       //count大于maxInLen需要更新index和maxInLen
                index = i - len + 1;
                maxInLen = count;
            }
        }

        double CFG = Math.pow(maxInLen, (double) 1 / len);   //求出乘积的Len次方根

        if (CFG > max) {
            max = CFG;
            return true;
        }
        return false;
    }
}